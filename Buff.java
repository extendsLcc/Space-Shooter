import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.reflect.Constructor;

public class Buff extends Main
{

    private BuffData This;
    private long l;
    private long time = System.currentTimeMillis();
    private int duration;
    private Units target;
    private List < SpecialEffect > effects = new ArrayList();
    private BuffEffect be;

    public Buff( Units target, BuffData bd, float dr ){

        This = bd;
        duration = (int) dr * 1000;
        target.buffs.add( this );

        for ( EffectData ed: This.effects ){

            effects.add( new SpriteEffect( ed ) );

        }

    }

    public Buff(){

        This = Buffs[1];
        duration = (int) 60 * 1000;

        for ( EffectData ed: This.effects ){

            effects.add( new SpriteEffect( ed ) );

        }

        target = ( Units )w.getObjects( Player.class ).get(0);

    }

    public void addedToWorld( World world ){

        l = System.currentTimeMillis();
        int x = target.getX(), y = target.getY();
        setLocation( x, y );
        getImage().clear();

        try{    //http://stackoverflow.com/questions/17485297/java-how-to-instantiate-inner-class-with-reflection?lq=1

            be = (BuffEffect)  This.clz.getDeclaredConstructor( this.getClass() ).newInstance( this );

        }catch( Exception e) {} 

        for( SpecialEffect sfx: effects ){

            w.addObject( sfx, x, y );

        }

    }

    public void act() 
    {

        if ( target.getWorld() != null ){

            int x =target.getX(), y = target.getY();

            setLocation( x, y );

            for( SpecialEffect e : effects ){

                e.setLocation( x, y );

            }

        }else duration = 0;

        if( System.currentTimeMillis() - l  >= duration ){

            target.buffs.remove( this );
            w.removeObject( this );
            be.destroy();

            for( SpecialEffect e : effects ){

                w.removeObject( e );

            }

            return;

        }

        if ( System.currentTimeMillis() - time >= This.timer ){

            time += This.timer;
            be.buffEffect();

        }

    }    

    class sphreeShield implements BuffEffect{

        private ArrayList< SpriteEffect > sfxs = new ArrayList<SpriteEffect>();

        public void buffEffect(){

            for( Projectil p: getObjectsInRangeXY( target.getX(), target.getY(), 100, Projectil.class ) ){

                if( p.cls == target.getClass() ) {

                    p.fade = true;
                    SpriteEffect e = new SpriteEffect( Effects[7] );
                    w.addObject( e, target.getX(), target.getY() );
                    sfxs.add( e );

                }

            }

            for( int i = 0; i < sfxs.size(); i++ ){

                SpriteEffect e = sfxs.get( i );

                if ( e.getWorld() == null ){

                    sfxs.remove( e );
                    i--;

                }else{

                    e.setLocation(  target.getX(), target.getY() );

                }

            }

        }

        public void destroy(){

            while( sfxs.size() != 0 ){

                SpriteEffect e = sfxs.get( 0 );
                sfxs.remove( e );

            }

        }

    }

    class spiningShield implements BuffEffect{

        private ArrayList < Projectil > list = new ArrayList<Projectil>();
        private long delay = System.currentTimeMillis();
        private int[] deg = new int[10];

        public void buffEffect(){

            if ( System.currentTimeMillis() - delay >= 1000 && list.size() < 10 ){

                delay = System.currentTimeMillis();
                Projectil p = new Projectil( Ammos[3], Inimigo.class );
                w.addObject( p, target.getX(), target.getY() );
                list.add( p );
                deg[ list.size() - 1] = target.getRotation();

            }

            for( int b = 1; b < list.size(); b++){

                int target = ( deg[0] + b * ( 360 / list.size() ) )% 360 ;
                
                if ( deg[b] != target ){
                    
                    int dif = deg[b] - target,
                    tmp = 0;
                    
                    if( dif > 0 && Math.abs( dif ) <= 180 || dif < 0 && Math.abs( dif ) > 180 ) tmp = -3;
                    else if( dif < 0 && Math.abs( dif ) <= 180 || dif > 0 && Math.abs( dif ) > 180 ) tmp = 2;
                    
                    /*if ( dif > 0 && Math.abs( dif ) <= 180 ) tmp = -3;
                    else if ( dif > 0 && Math.abs( dif ) > 180 ) tmp = 2;
                    else if ( dif < 0 && Math.abs( dif ) <= 180 ) tmp = 2;
                    else if ( dif < 0 && Math.abs( dif ) > 180 ) tmp = -3;
                    //tmp = ( dif > 0 && Math.abs( dif ) <= 180 || dif < 0 && Math.abs( dif ) > 180 ) ? -3 : 2;
                    */
                    deg[b] += tmp;
                    if( deg[b] < 0 ) deg[b] = 359 + deg[b];
                    
                }            
                
            }
            
            for( int i = 0; i < list.size(); i++ ){

                Projectil p = list.get( i );

                if( p.getWorld() == null ){

                    list.remove(p);
                    i--;               
                    continue;

                }
                
                int x = target.getX(), y = target.getY();
                deg[i] += 2;
                if ( deg[i] > 359 ) deg[i] -= 360;
                p.setLocationOffset( x, y, 120, deg[i] ); 
                p.setRotation( (int) angleBetween( x, y, p.getX(),p.getY() ) + 90 );

                for ( Projectil pro: (List<Projectil>) p.getObjectsAtRange( 50, Projectil.class ) ){

                    if ( pro.cls == target.getClass() ){

                        pro.fade = true;
                        w.removeObject( p );

                    }

                }

            }

        }

        public void destroy(){

            for( Projectil p: list ){

                p.fade = true;

            }

        }

    }
    
}

import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class Sprite  
{

    static public GreenfootImage getSprite( GreenfootImage spriteList, int startX, int startY, int width, int height, int fWidth, int fHeight ){

        GreenfootImage img = new GreenfootImage( width, height );
        int finalX = startX + width,
        finalY = startY + height;

        for( int x = startX; x < finalX; x++ ){

            for( int y = startY; y < finalY; y++ ){

                if( x < spriteList.getWidth() && x >= 0 && y < spriteList.getHeight() && y >= 0 ){

                    img.setColorAt( width - ( finalX - x ), height - ( finalY - y ), spriteList.getColorAt( x, y ) );

                }

            }

        }

        img.scale( fWidth, fHeight );
        return img;

    }
    
    static public GreenfootImage getSprite( GreenfootImage spriteList, int width, int height, int index, int fWidth, int fHeight ){

        int s = spriteList.getWidth()/width;
        
        return getSprite( spriteList, index % s * width , index / s * height , width, height, fWidth, fHeight );
        
    }

    static public List < GreenfootImage > getSprites( GreenfootImage spriteList, int startX, int startY, int width, int height, int number, int fWidth, int fHeight ){

        List < GreenfootImage > sprites = new ArrayList < GreenfootImage >();
        int x = 0, y = 0;

        for( int i = 0; i < number && y * height < spriteList.getHeight(); i++ ){

            sprites.add( getSprite( spriteList, startX + x * width, startY + y * height , width, height, fWidth, fHeight ) );

            if ( spriteList.getWidth() - ( Math.max( 1, x ) * width ) > width )  x++; else { x = 0; y++; }
            
        }

        return sprites;

    }
    
    static public List < GreenfootImage > getSprites( GreenfootImage spriteList, int width, int height, int fWidth, int fHeight ){
    
        List < GreenfootImage > sprites = new ArrayList< GreenfootImage >();
        int f = ( spriteList.getWidth() / width ) * ( spriteList.getHeight() / height );
        
        for ( int i = 0; i < f; i++ ){
        
            sprites.add( getSprite( spriteList, width, height, i, fWidth, fHeight ) );
            
        }
    
        return sprites;
        
    }

}
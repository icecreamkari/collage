import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture1 extends SimplePicture //implements colorinterface
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture1 ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture1(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture1(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture1(Picture1 copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture1(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

//////////////////////////////new methods///////////////////////////////

  /**
   * Method to negate the picture
   */
   public void negate()
   {   //!!!!!!!!! this copies the picture into array
   	   //!!!!!!!!! large pictures could cause out of memory error!!!!!
	   Pixel[] pixelArray = this.getPixels();
	   Pixel pixel = null;
	   int redValue, blueValue, greenValue =0;

	   //loop through all the pixels
	   for (int i = 0; i<pixelArray.length; i++)
	   {
		   //get the current pixel
		   pixel = pixelArray[i];

		   //get the current red,green and blue vllues
		   redValue = pixel.getRed();
		   greenValue = pixel.getGreen();
		   blueValue = pixel.getBlue();

		   //set the pixel's color to the new color
		   pixel.setColor(new Color(255 - redValue,
		   							255 - greenValue,
		   							255 - blueValue));
	   }//end of for
   }//end of negate


  /**
   * Method to mirror around a horizontal line in the middle
   * based on the height.
   */
   public void mirrorHorizontal()
   {
	   String sourceFile = ("images\\totoro.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = (sourcePicture.getWidth()/2), targetX = sourcePicture.getWidth()/2;
	   		sourceX > 0;
	   		sourceX--, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = 0;
		   		sourceY < sourcePicture.getHeight();
		   		sourceY++, targetY++)
		   {

		   		//set the target pixel color to the source pixel color
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop

	}//end of mirrorHorizontal


   public void copyTotoro(int x, int y)
   {
	   String sourceFile = ("images\\totoro.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

		//width of source must be = or < the canvas I am copy to
	   //loop through the columns
	   for (int sourceX = 0, targetX=x;
	   		sourceX < sourcePicture.getWidth();
	   		sourceX++, targetX++)
	   {
	   //loop throught the rows
		   for (int sourceY = 0, targetY = y;
		   		sourceY < sourcePicture.getHeight();
		   		sourceY++, targetY++)
		   {
		   		//set the target pixel color to the source pixel color
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop

   }//end of copy totoro



  	/**
   	* Method to blend a souce picture onto the current picture
   	*100% of one picture = picture
   	* 50% or one picture + 50% of another picture = 100% of blended picture
    */


	public void blendPictures(String file)
	{
   	   String sourceFile = ("images\\totoro.jpg");
   	   Picture blendPicture = new Picture(file);
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;
	   Pixel blendPixel = null;

		//width of source must be = or < the canvas I am copy to
	   //loop through the columns
	   for (int sourceX = 0, targetX=0, blendX = 0;
	   		sourceX < sourcePicture.getWidth();
	   		sourceX++, targetX++, blendX++)
	   {
	   //loop throught the rows
		   for (int sourceY = 0, targetY = 0, blendY = 0;
		   		sourceY < sourcePicture.getHeight();
		   		sourceY++, targetY++, blendY++)
		   {
		   		//set the target pixel color to the source pixel color
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		blendPixel = blendPicture.getPixel(blendX, blendY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(new Color((sourcePixel.getRed() + blendPixel.getRed())/2,
		   		(sourcePixel.getGreen() + blendPixel.getGreen())/2,
		   		(sourcePixel.getBlue() + blendPixel.getBlue())/2));
			}//row loop

	   }//col loop

	}

   public void recursiveTotoro(int factor)
   {

	  	String sourceFile = ("images\\totoro.jpg");
	   	Picture sourcePic = new Picture(sourceFile);

	    Pixel sourcePixel = null;
	    Pixel targetPixel = null;

	  	   //loop through the columns
	  	   for (int sourceX = 0, targetX=sourcePic.getWidth();
	  	   		sourceX < sourcePic.getWidth();
	  	   		sourceX+=factor, targetX--)
	  	   {
	  		   //loop throught the rows
	  		   for (int sourceY = 0, targetY = 0;
	  		   		sourceY < sourcePic.getHeight();
	  		   		sourceY+=factor, targetY++)
	  		   {
	  				//set the target pixel color to the source pixel color
	  				sourcePixel = sourcePic.getPixel(sourceX,sourceY);
	  				targetPixel = this.getPixel(targetX,targetY);
	  				targetPixel.setColor(sourcePixel.getColor());
	  			}//row loop

	   }//col loop

	   if (factor < 10)
	  		recursiveTotoro(factor+1);

   }//end of recursive totoro

	/**
	* Method to change the picture to grayscale
	*/


	public void grayscale()
	{//!!!!!! again copies all the pixels into an array!!!!!
		Pixel[] pixelArray = this.getPixels();
		Pixel pixel = null;
		int intensity = 0;

		for (int i = 0; i < pixelArray.length; i++)
		{
			//get the current pixel
			pixel = pixelArray[i];

			//compute the intensity of the pixel (average value)
			intensity = (int) ((pixel.getRed() + pixel.getGreen()+
							   pixel.getBlue())/3);

			//set the pixel color to the new color
			pixel.setColor(new Color(intensity,intensity,intensity));
		}//end of for

	}



	/**
   	* Method to do a simple edge detection by comparing the
   	* absolute value of the difference between the color
   	* intensities (average of the color values) between a
   	* pixel and the pixel below it.  If the absolute value
   	* of the difference between the color intensities is
   	* less than a passed amount the top pixel color
   	* will be set to white. Otherwise it is set to black.
   	* @param amount if the absolute value of the differences
   	* in the color average is less thatn this
   	* set the color to white, else black
    */
	public void edgeDetection( double amount)
	{
	}



  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

} // this } is the end of class Picture, put all new methods before this

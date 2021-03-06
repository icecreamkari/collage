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
public class Picture extends SimplePicture //implements colorinterface
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
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
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
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
   * Method to mirror around a vertical line in the middle
   * of the picture based on the width
   */
   public void mirrorVertical()
   {
String sourceFile = ("images\\KatieFancy.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = 0, targetX=0;
	   		sourceX < sourcePicture.getWidth();
	   		sourceX++, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = sourcePicture.getHeight();
		   		sourceY < (sourcePicture.getHeight()/2);
		   		sourceY++, targetY--)
		   {

		   		//set the target pixel color to the source pixel color
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop

	   /**
	   int width = this.getWidth();
	   int mirrorPoint = width/2;
	   Pixel leftPixel = null;
	   Pixel rightPixel = null;

	   //loop through all the rows
	   for (int y = 0; u < getHeight(); y++)
	   {

		   //loop from 0 to the middle (mirror point)
		   for (int x = 0; x< mirrorPoint; x++)
		   {
			   leftPixel = getPixel(x, y);
			   rightPixel = getPixel(width-1-x, y);
			   rightPixel.setColor(leftPixel.getColor());

		   }//end of x loop

	   }//end of y loop
	   **/

	}//end of mirrorVertical


  /**
   * Method to mirror around a horizontal line in the middle
   * based on the height. It copies the top mirrored to the
   * bottom
   */
   public void mirrorHorizontal()
   {
	   String sourceFile = ("images\\KatieFancy.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = sourcePicture.getWidth(), targetX=sourcePicture.getWidth();
	   		sourceX < (sourcePicture.getWidth()*2);
	   		sourceX--, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = 100;
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



  /**
   * Method to mirror around a horizontal line in the middle
   * based on the height. It copies the top mirrored to the
   * bottom
   */
   public void mirrorHorizontalBottomToTop()
   {


	}//end of mirrorHorizontal

	/**
	   * Method to copy the picture of Katie to the
	   * upper left corner of the current picture
   */


   public void copyKatie(/*sourceFile*/)
   {
	   String sourceFile = ("images\\KatieFancy.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

		//width of source must be = or < the canvas I am copy to
	   //loop through the columns
	   for (int sourceX = 0, targetX=0;
	   		sourceX < sourcePicture.getWidth();
	   		sourceX++, targetX++)
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

   }//end of copy cate

	/**
	   * Method to copy the picture of Katie to (100,100) in the
	   * current picture
   */

   public void copyKatieMidway()
   {
	   String sourceFile = ("images\\KatieFancy.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = 0, targetX=100;
	   		sourceX < sourcePicture.getWidth();
	   		sourceX++, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = 100;
		   		sourceY < sourcePicture.getHeight();
		   		sourceY++, targetY++)
		   {

		   		//set the target pixel color to the source pixel color
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop

   }//end of copy cateMidway
   	/**
   	   * Method to copy just Katie's face to the current pictue
   	   *
      */

      public void copyKatieFace()
      {

String sourceFile = ("images\\KatieFancy.jpg");
	   Picture sourcePicture = new Picture(sourceFile);

	   Pixel sourcePixel = null;
	   Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = 69, targetX=100;
	   		sourceX < 132;
	   		sourceX++, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = 100;
		   		sourceY < 81;
		   		sourceY++, targetY++)
		   {

		   		//set the target pixel color to the source pixel color
		   		sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
		   		targetPixel = this.getPixel(targetX,targetY);
		   		targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop


   }//end of copyKatiesFace

  	/**
   	* Method to blend a souce picture onto the current picture
   	*100% of one picture = picture
   	* 50% or one picture + 50% of another picture = 100% of blended picture
    */


	public void blendPictures(String file)
	{


	}

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
   	* Method to copy the picture of rose but smaller
   	* (half) as big) to the current picture
    */
	public void copyflowerSmaller(/*fileName*/)
	{
		Picture flowerPicture = (new Picture("images\\rose.jpg"));

		Pixel sourcePixel = null;
   	   	Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = 0, targetX=0;
	   		sourceX < flowerPicture.getWidth();
	   		sourceX+=2, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = 0;
		   		sourceY < flowerPicture.getHeight();
		   		sourceY+=2, targetY++)
		   {

				//set the target pixel color to the source pixel color
				sourcePixel = flowerPicture.getPixel(sourceX,sourceY);
				targetPixel = this.getPixel(targetX,targetY);
				targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop

	}//end of CopySmaller

	/**
   	* Method to copy but scaled to 2x the normal size
   	* onto the current picture
    */
	public void copyflowerLarger(/*fileName*/)
	{

	}//end of CopyLarger

	/**
   	* Method to change the current picture to a sepia
   	* tint (modify the middle colors to a light brown and
   	* the light colors to a light yellow and make the
   	* shadows darker)
    */
	public void sepiaTint()
	{


	}//end of sepiaTint


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

	/**
   	* Method to copy the picture of rose but smaller
   	* (half) as big) to the current picture
    */
	public void scale(Picture sourcePic /*, double factor*/)
	{
		//Picture flowerPicture = (new Picture("images\\rose.jpg"));

		Pixel sourcePixel = null;
   	   	Pixel targetPixel = null;

	   //loop through the columns
	   for (int sourceX = 0, targetX=0;
	   		sourceX < sourcePic.getWidth();
	   		sourceX+=2, targetX++)
	   {
		   //loop throught the rows
		   for (int sourceY = 0, targetY = 0;
		   		sourceY < sourcePic.getHeight();
		   		sourceY+=2, targetY++)
		   {

				//set the target pixel color to the source pixel color
				sourcePixel = sourcePic.getPixel(sourceX,sourceY);
				targetPixel = this.getPixel(targetX,targetY);
				targetPixel.setColor(sourcePixel.getColor());
			}//row loop

	   }//col loop

	}//end of CopySmaller


  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

} // this } is the end of class Picture, put all new methods before this

import java.awt.*;
//import java.awt.font.*;
//import java.awt.geom.*;
//import java.awt.image.BufferedImage;
//import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class collage
{
/**
* Test Main.  It will ask you to pick a file and then show it
*/
public static void main( String args[])
{
	final double FACTOR = .5;
	Color color = Color.green;
	Color color2 = new Color(150,150,150);



	//relative path
	//Picture p1 = new Picture("images\\temple.jpg");
	//Picture p2 = new Picture("images\\rose.jpg");
	//p2.explore();
	//System.out.println(p  );
	//p.show();
	//p.explore();
	//p.negate();

	Picture1 copyTo = new Picture1("images\\newcanvas.jpg");
	//copyTo.explore();

	copyTo.copyTotoro(0,0);
	//copyTo.explore();
	//copyTo.copyKatieMidway();
	//copyTo.explore();

	//copyTo.copyKatieFace();
	//copyTo.explore();

	//copyTo.mirrorVertical();
	//copyTo.explore();

	//copyTo.mirrorHorizontal();
	//copyTo.explore();

	copyTo.blendPictures("images\\meadow2.jpg");


	//copyTo.recursiveTotoro(1);
	//copyTo.explore();

	//copyTo.grayscale();
	copyTo.explore();


	//p3.negate();
	//copyTo.copyflowerSmaller();

	//copyTo.explore();

	//copyTo.scale(p3);
	//copyTo.explore();

}//end of main
}//end of class

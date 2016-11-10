/** Ben F Rayfield offers JSoundCard under Apache 2, GNU LGPL, and/or Classpath Exception. */
package jsoundcard;

/** TODO speakers() and microphones() quantities are useful information
but this class is not the right place for them because code can be evolved
without needing that information.
public int speakers();
public int microphones();
*/
public interface FrameSize{
	
	/** How many audio channels? Each frame is this number of numbers in range -1 to 1.
	speakers()+microphones() <= frameSize().
	*/
	public int frameSize();

}
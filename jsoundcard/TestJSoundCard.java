/** Ben F Rayfield offers JSoundCard under Apache 2, GNU LGPL, and/or Classpath Exception. */
package jsoundcard;
import jsoundcard.example.*;
import jsoundcard.hardware.*;
import java.util.*;
import javax.sound.sampled.Mixer;

public class TestJSoundCard{
	private TestJSoundCard(){}

	/** Play some test sounds, including microphone-speakers interaction */
	public static void main(String args[]) throws Exception{
		JSoundCard.log("In this version of JSoundCard, the timing of the buffers is adjusted ok but could be improved. You have to have 1 microphone. In future versions, it will allow any small number of speakers and/or microphones and multiple sound cards at once. To do that, it will have to listen to all microphones to make sure they can hear anything, and play something on the speakers to make sure the microphones hear them. A fast test can be run when the software starts and when the user clicks a button to do the test again after changing the speakers/microphones, in later versions. For now you can use it with simple options like 2 speakers and 1 microphone.");
		JSoundCard.sleepSeconds(1.);
		//Play 2 test sounds
		SoundFunc testSounds[] = new SoundFunc[]{
			new ExampleSoundFuncAmplifyMicrophoneOn2Speakers(),
			new ExampleSoundFuncSimpleSineWave(3)
		};
		int seconds = 10;
		int i = 0;
		for(SoundFunc f : testSounds){
			JSoundCard.log("About to play: "+f+" for "+seconds+" seconds...");
			JSoundCard.play(f, 2, 1, JSoundCard.DEFAULT_FRAMES_PER_SECOND);
			JSoundCard.log("Started playing "+f);
			Thread.sleep(1000*seconds);
			JSoundCard.log("About to end playing...");
			JSoundCard.stop();
			JSoundCard.log("Ended playing. You should have heard "+f+" for "+seconds+" seconds.");
		}
	}
}
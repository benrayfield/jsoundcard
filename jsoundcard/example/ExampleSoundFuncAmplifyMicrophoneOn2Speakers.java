/** Ben F Rayfield offers JSoundCard under Apache 2, GNU LGPL, and/or Classpath Exception. */
package jsoundcard.example;
import jsoundcard.*;

public class ExampleSoundFuncAmplifyMicrophoneOn2Speakers implements SoundFunc{
	
	double volume = .7;
	
	//double averageAbsValMicrophoneAmplitude = .5;
	
	double maxMicrophoneAmplitude = 1;
	
	public int frameSize(){ return 3; }
	
	//int frames=0;
	
	public void readWriteFrame(double frame[]){
		double microphoneAmplitude = frame[2];
		int estimatedFramesPerSecond = 44100;
		//if(frames++ % estimatedFramesPerSecond == 0) JSoundCard.log("microphoneAmplitude="+microphoneAmplitude);
		double decaySeconds = .1;
		double decay = 1/(estimatedFramesPerSecond*decaySeconds);
		//averageAbsValMicrophoneAmplitude = averageAbsValMicrophoneAmplitude*(1-decay)
		//	+ decay*Math.abs(microphoneAmplitude);
		maxMicrophoneAmplitude = Math.max(maxMicrophoneAmplitude, microphoneAmplitude);
		maxMicrophoneAmplitude = maxMicrophoneAmplitude*(1-decay);
		frame[0] = microphoneAmplitude/maxMicrophoneAmplitude * volume;
		frame[1] = microphoneAmplitude/maxMicrophoneAmplitude * volume;
	}

}
/** Ben F Rayfield offers JSoundCard under Apache 2, GNU LGPL, and/or Classpath Exception. */
package jsoundcard.example;
import jsoundcard.SoundFunc;

public class ExampleSoundFuncSimpleSineWave implements SoundFunc{
	
	double x;
	
	int channels;
	
	double volume = .4;
	
	public ExampleSoundFuncSimpleSineWave(int channels){
		this.channels = channels;
	}
	
	public int frameSize(){ return channels; }
	
	public void readWriteFrame(double frame[]){
		x += .3;
		double circle = 2*Math.PI;
		for(int i=0; i<channels; i++){
			frame[i] = volume*Math.sin(x+i*circle/channels);
		}
	}

}
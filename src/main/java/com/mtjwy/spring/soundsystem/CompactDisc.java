package com.mtjwy.spring.soundsystem;

/*
 * We defined a interface CompactDisc. As an interface, it defines the
 * contract through which a CDplayer can operate on the CD. And it keeps the
 * coupling between any CD player implementation and the CD itself to a
 * minimum.
 */
public interface CompactDisc {
	void play();
	
}

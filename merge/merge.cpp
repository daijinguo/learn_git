#include "merge.h"

#include <stdio.h>

void func_close(int code){
	if( code <= 0 )
		return;
	
	close( code );
}

void func_wait( int code ){
	if( code <= 0 )
		return;
	
	// function implement
}

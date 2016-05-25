#include "epoll.h"

int epool_create() {
	return 0;
}

void epoll_close( int epoll_id ) {
	if( 0 == epoll_id )
		return;
	
	// close the  epoll
}
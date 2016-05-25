#include "epoll.h"

<<<<<<< HEAD
<<<<<<< HEAD
void epoll_poll(int id){
	
=======
int epool_create() {
	return 0;
}

void epoll_close( int epoll_id ) {
	if( 0 == epoll_id )
		return;
	
	// close the  epoll
>>>>>>> epoll1
=======
void epoll_wait( int epoll_id) {
	if( epoll_id <= 0 )
		return;
	
	// implement the wait
>>>>>>> epoll2
}
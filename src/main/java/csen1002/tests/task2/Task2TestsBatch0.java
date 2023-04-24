package csen1002.tests.task2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task2.NfaToDfa;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task2TestsBatch0 {

	@Test
	public void testNfa1() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8;9;10;11;12#c;d;i;n#0,i,1;1,e,8;1,e,10;2,c,3;3,e,9;4,n,5;5,e,4;5,e,7;6,e,4;6,e,7;7,e,9;8,e,2;8,e,6;9,e,12;10,d,11;11,e,12#0#12");
		assertEquals("-1;0;1/2/4/6/7/8/9/10/12;3/9/12;4/5/7/9/12;11/12#c;d;i;n#-1,c,-1;-1,d,-1;-1,i,-1;-1,n,-1;0,c,-1;0,d,-1;0,i,1/2/4/6/7/8/9/10/12;0,n,-1;1/2/4/6/7/8/9/10/12,c,3/9/12;1/2/4/6/7/8/9/10/12,d,11/12;1/2/4/6/7/8/9/10/12,i,-1;1/2/4/6/7/8/9/10/12,n,4/5/7/9/12;3/9/12,c,-1;3/9/12,d,-1;3/9/12,i,-1;3/9/12,n,-1;4/5/7/9/12,c,-1;4/5/7/9/12,d,-1;4/5/7/9/12,i,-1;4/5/7/9/12,n,4/5/7/9/12;11/12,c,-1;11/12,d,-1;11/12,i,-1;11/12,n,-1#0#1/2/4/6/7/8/9/10/12;3/9/12;4/5/7/9/12;11/12", nfaToDfa.toString());
	}

	@Test
	public void testNfa2() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8#m;z#0,m,4;0,m,1;0,m,6;0,m,3;0,z,2;0,z,4;0,z,6;0,z,8;1,m,5;1,m,0;1,m,1;1,m,6;1,z,3;1,z,5;1,z,0;1,z,4;1,z,6;1,z,2;1,z,1;2,m,3;2,m,5;2,m,1;2,m,6;2,z,3;2,z,1;2,z,0;2,z,6;3,m,6;3,m,8;3,m,0;3,m,1;3,z,4;3,z,6;3,z,7;3,z,1;4,m,2;4,m,4;4,m,8;4,m,5;4,m,6;4,z,0;4,z,7;4,z,4;4,z,2;4,z,1;4,z,5;4,z,3;5,m,0;5,m,6;5,m,8;5,m,4;5,m,7;5,m,5;5,m,3;5,z,2;5,z,1;5,z,4;5,z,0;5,z,5;6,m,4;6,m,0;6,m,8;6,m,2;6,m,6;6,m,3;6,z,1;6,z,5;6,z,0;6,z,3;7,m,3;7,m,2;7,m,0;7,m,7;7,z,5;7,z,7;7,z,1;7,z,3;8,m,7;8,m,1;8,m,4;8,m,0;8,z,7;8,z,4;8,z,8;8,z,5;8,z,6;8,z,2#3#2;4;7;8");
		assertEquals("0/1/2/3/4/5/6/7;0/1/2/3/4/5/6/7/8;0/1/6/8;1/4/6/7;3#m;z#0/1/2/3/4/5/6/7,m,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7,z,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,m,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,z,0/1/2/3/4/5/6/7/8;0/1/6/8,m,0/1/2/3/4/5/6/7/8;0/1/6/8,z,0/1/2/3/4/5/6/7/8;1/4/6/7,m,0/1/2/3/4/5/6/7/8;1/4/6/7,z,0/1/2/3/4/5/6/7;3,m,0/1/6/8;3,z,1/4/6/7#3#0/1/2/3/4/5/6/7;0/1/2/3/4/5/6/7/8;0/1/6/8;1/4/6/7", nfaToDfa.toString());
		                  // 0/1/2/3/4/5/6/7;0/1/2/3/4/5/6/7/8;0/1/6/8;1/4/6/7;3#m;z#0/1/2/3/4/5/6/7,m,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7,z,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,m,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,z,0/1/2/3/4/5/6/7/8;0/1/6/8,m,0/1/2/3/4/5/6/7/8;0/1/6/8,z,0/1/2/3/4/5/6/7/8;1/4/6/7,m,0/1/2/3/4/5/6/7/8;1/4/6/7,z,0/1/2/3/4/5/6/7;3,m,0/1/6/8;3,z,1/4/6/7#3#0/1/2/3/4/5/6/70/1/2/3/4/5/6/7/80/1/6/81/4/6/7
	}

	@Test
	public void testNfa3() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8;9;10;11#b;y#0,b,3;0,b,8;0,b,10;0,b,6;0,b,9;0,b,11;0,b,5;0,y,9;0,y,8;0,y,0;0,y,5;1,b,6;1,b,8;1,b,2;1,b,7;1,b,11;1,b,3;1,b,0;1,y,4;1,y,6;1,y,8;1,y,1;1,y,3;1,y,10;2,b,9;2,b,2;2,b,7;2,b,11;2,b,4;2,b,10;2,b,0;2,y,1;2,y,2;2,y,4;2,y,11;3,b,2;3,b,7;3,b,11;3,b,9;3,b,3;3,y,1;3,y,2;3,y,7;3,y,8;3,y,3;3,y,6;3,y,5;4,b,2;4,b,5;4,b,0;4,b,11;4,b,3;4,b,1;4,y,9;4,y,6;4,y,10;4,y,0;4,y,1;4,y,2;5,b,3;5,b,7;5,b,8;5,b,4;5,b,10;5,b,11;5,y,11;5,y,8;5,y,4;5,y,10;5,y,5;5,y,7;5,y,1;6,b,10;6,b,11;6,b,7;6,b,5;6,b,3;6,y,2;6,y,0;6,y,6;6,y,11;6,y,4;7,b,7;7,b,9;7,b,5;7,b,10;7,b,2;7,b,0;7,b,6;7,y,8;7,y,5;7,y,2;7,y,10;7,y,4;7,y,11;8,b,9;8,b,2;8,b,8;8,b,7;8,b,3;8,b,0;8,b,6;8,y,3;8,y,1;8,y,5;8,y,2;8,y,10;8,y,9;9,b,11;9,b,7;9,b,2;9,b,4;9,b,0;9,b,8;9,b,1;9,y,8;9,y,5;9,y,1;9,y,3;9,y,4;9,y,10;9,y,9;10,b,7;10,b,10;10,b,4;10,b,0;10,b,2;10,y,3;10,y,5;10,y,9;10,y,8;11,b,2;11,b,6;11,b,7;11,b,4;11,y,3;11,y,7;11,y,10;11,y,5;11,y,1;11,y,11;11,y,8#7#0;1;9");
		assertEquals("0/1/2/3/4/5/6/7/8/9/10/11;0/2/5/6/7/9/10;2/4/5/8/10/11;7#b;y#0/1/2/3/4/5/6/7/8/9/10/11,b,0/1/2/3/4/5/6/7/8/9/10/11;0/1/2/3/4/5/6/7/8/9/10/11,y,0/1/2/3/4/5/6/7/8/9/10/11;0/2/5/6/7/9/10,b,0/1/2/3/4/5/6/7/8/9/10/11;0/2/5/6/7/9/10,y,0/1/2/3/4/5/6/7/8/9/10/11;2/4/5/8/10/11,b,0/1/2/3/4/5/6/7/8/9/10/11;2/4/5/8/10/11,y,0/1/2/3/4/5/6/7/8/9/10/11;7,b,0/2/5/6/7/9/10;7,y,2/4/5/8/10/11#7#0/1/2/3/4/5/6/7/8/9/10/11;0/2/5/6/7/9/10", nfaToDfa.toString());
	}

	@Test
	public void testNfa4() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8#p;y#0,p,3;0,p,6;0,p,1;0,p,7;0,p,8;0,p,2;0,p,0;0,y,2;0,y,1;0,y,4;0,y,0;0,y,6;0,y,8;0,y,7;1,p,4;1,p,5;1,p,1;1,p,2;1,p,6;1,y,4;1,y,7;1,y,6;1,y,3;1,y,2;1,y,0;2,p,1;2,p,2;2,p,3;2,p,6;2,p,5;2,p,8;2,y,2;2,y,8;2,y,6;2,y,4;2,y,7;2,y,0;3,p,1;3,p,7;3,p,0;3,p,3;3,y,4;3,y,2;3,y,1;3,y,6;3,y,7;3,y,3;4,p,5;4,p,2;4,p,0;4,p,7;4,p,1;4,p,3;4,y,3;4,y,8;4,y,7;4,y,0;4,y,5;4,y,1;4,y,4;5,p,2;5,p,5;5,p,7;5,p,4;5,p,1;5,y,1;5,y,6;5,y,0;5,y,8;6,p,8;6,p,4;6,p,5;6,p,6;6,y,1;6,y,7;6,y,4;6,y,6;7,p,5;7,p,1;7,p,0;7,p,2;7,p,3;7,y,3;7,y,0;7,y,6;7,y,1;7,y,8;8,p,4;8,p,3;8,p,1;8,p,6;8,y,1;8,y,2;8,y,6;8,y,7#2#6;7");
		assertEquals("0/1/2/3/4/5/6/7/8;0/1/2/3/4/6/7/8;0/2/4/6/7/8;1/2/3/5/6/8;2#p;y#0/1/2/3/4/5/6/7/8,p,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,y,0/1/2/3/4/5/6/7/8;0/1/2/3/4/6/7/8,p,0/1/2/3/4/5/6/7/8;0/1/2/3/4/6/7/8,y,0/1/2/3/4/5/6/7/8;0/2/4/6/7/8,p,0/1/2/3/4/5/6/7/8;0/2/4/6/7/8,y,0/1/2/3/4/5/6/7/8;1/2/3/5/6/8,p,0/1/2/3/4/5/6/7/8;1/2/3/5/6/8,y,0/1/2/3/4/6/7/8;2,p,1/2/3/5/6/8;2,y,0/2/4/6/7/8#2#0/1/2/3/4/5/6/7/8;0/1/2/3/4/6/7/8;0/2/4/6/7/8;1/2/3/5/6/8", nfaToDfa.toString());
	}

	@Test
	public void testNfa5() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8;9#m;w#0,m,5;0,m,9;0,m,4;0,m,3;0,w,4;0,w,0;0,w,2;0,w,3;0,w,7;0,w,6;0,w,5;1,m,5;1,m,6;1,m,3;1,m,0;1,m,7;1,m,1;1,w,8;1,w,7;1,w,2;1,w,1;1,w,5;2,m,8;2,m,1;2,m,7;2,m,5;2,m,9;2,w,5;2,w,3;2,w,6;2,w,9;2,w,8;3,m,9;3,m,0;3,m,4;3,m,5;3,w,5;3,w,9;3,w,6;3,w,7;3,w,2;3,w,3;3,w,4;4,m,3;4,m,5;4,m,8;4,m,1;4,m,4;4,m,9;4,m,0;4,w,2;4,w,1;4,w,4;4,w,0;4,w,5;4,w,9;4,w,7;5,m,9;5,m,3;5,m,2;5,m,1;5,m,0;5,w,5;5,w,6;5,w,0;5,w,3;6,m,5;6,m,8;6,m,7;6,m,1;6,m,2;6,m,4;6,w,5;6,w,0;6,w,9;6,w,2;6,w,1;6,w,6;6,w,8;7,m,1;7,m,3;7,m,5;7,m,4;7,m,2;7,m,8;7,m,0;7,w,4;7,w,8;7,w,0;7,w,1;7,w,7;7,w,5;7,w,6;8,m,3;8,m,7;8,m,9;8,m,4;8,m,5;8,w,4;8,w,3;8,w,5;8,w,9;8,w,0;9,m,4;9,m,3;9,m,5;9,m,1;9,m,7;9,m,0;9,m,9;9,w,7;9,w,8;9,w,3;9,w,5;9,w,4;9,w,2#9#3;6;7;8");
		assertEquals("0/1/2/3/4/5/6/7/8/9;0/1/2/3/4/5/7/8/9;0/1/3/4/5/7/9;2/3/4/5/7/8;9#m;w#0/1/2/3/4/5/6/7/8/9,m,0/1/2/3/4/5/6/7/8/9;0/1/2/3/4/5/6/7/8/9,w,0/1/2/3/4/5/6/7/8/9;0/1/2/3/4/5/7/8/9,m,0/1/2/3/4/5/6/7/8/9;0/1/2/3/4/5/7/8/9,w,0/1/2/3/4/5/6/7/8/9;0/1/3/4/5/7/9,m,0/1/2/3/4/5/6/7/8/9;0/1/3/4/5/7/9,w,0/1/2/3/4/5/6/7/8/9;2/3/4/5/7/8,m,0/1/2/3/4/5/7/8/9;2/3/4/5/7/8,w,0/1/2/3/4/5/6/7/8/9;9,m,0/1/3/4/5/7/9;9,w,2/3/4/5/7/8#9#0/1/2/3/4/5/6/7/8/9;0/1/2/3/4/5/7/8/9;0/1/3/4/5/7/9;2/3/4/5/7/8", nfaToDfa.toString());
	}

	@Test
	public void testNfa6() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8#j;r;v#0,j,8;0,j,7;0,j,2;0,j,0;0,j,1;0,r,6;0,r,8;0,r,2;0,r,3;0,r,1;0,v,6;0,v,2;0,v,5;0,v,3;0,v,0;0,v,4;0,v,1;1,j,0;1,j,3;1,j,8;1,j,6;1,j,7;1,j,5;1,r,1;1,r,5;1,r,2;1,r,4;1,v,5;1,v,2;1,v,3;1,v,8;1,v,4;1,v,0;2,j,5;2,j,7;2,j,3;2,j,0;2,j,1;2,j,4;2,r,6;2,r,1;2,r,0;2,r,3;2,r,2;2,r,5;2,v,0;2,v,3;2,v,1;2,v,6;3,j,8;3,j,6;3,j,0;3,j,5;3,j,1;3,j,7;3,j,4;3,r,5;3,r,3;3,r,8;3,r,2;3,v,6;3,v,1;3,v,0;3,v,4;3,v,7;3,v,2;3,v,3;4,j,2;4,j,8;4,j,3;4,j,5;4,j,0;4,j,4;4,j,1;4,r,4;4,r,2;4,r,6;4,r,0;4,v,8;4,v,5;4,v,7;4,v,1;5,j,1;5,j,5;5,j,2;5,j,8;5,j,3;5,r,5;5,r,8;5,r,7;5,r,4;5,r,2;5,r,6;5,v,7;5,v,5;5,v,3;5,v,8;6,j,2;6,j,1;6,j,8;6,j,4;6,j,5;6,j,7;6,r,0;6,r,6;6,r,3;6,r,5;6,r,4;6,r,7;6,v,8;6,v,3;6,v,0;6,v,7;6,v,6;6,v,1;6,v,4;7,j,2;7,j,4;7,j,7;7,j,5;7,j,0;7,j,6;7,r,2;7,r,6;7,r,3;7,r,0;7,v,4;7,v,6;7,v,3;7,v,0;8,j,5;8,j,1;8,j,3;8,j,4;8,j,6;8,j,8;8,j,7;8,r,6;8,r,0;8,r,5;8,r,4;8,r,3;8,r,2;8,r,1;8,v,3;8,v,4;8,v,2;8,v,5#1#0;1;4");
		assertEquals("0/1/2/3/4/5/6/7/8;0/2/3/4/5/8;0/3/5/6/7/8;1;1/2/4/5#j;r;v#0/1/2/3/4/5/6/7/8,j,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,r,0/1/2/3/4/5/6/7/8;0/1/2/3/4/5/6/7/8,v,0/1/2/3/4/5/6/7/8;0/2/3/4/5/8,j,0/1/2/3/4/5/6/7/8;0/2/3/4/5/8,r,0/1/2/3/4/5/6/7/8;0/2/3/4/5/8,v,0/1/2/3/4/5/6/7/8;0/3/5/6/7/8,j,0/1/2/3/4/5/6/7/8;0/3/5/6/7/8,r,0/1/2/3/4/5/6/7/8;0/3/5/6/7/8,v,0/1/2/3/4/5/6/7/8;1,j,0/3/5/6/7/8;1,r,1/2/4/5;1,v,0/2/3/4/5/8;1/2/4/5,j,0/1/2/3/4/5/6/7/8;1/2/4/5,r,0/1/2/3/4/5/6/7/8;1/2/4/5,v,0/1/2/3/4/5/6/7/8#1#0/1/2/3/4/5/6/7/8;0/2/3/4/5/8;0/3/5/6/7/8;1;1/2/4/5", nfaToDfa.toString());
	}

	@Test
	public void testNfa7() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8;9;10;11#k;n;w#0,w,1;1,n,2;2,e,0;2,e,4;3,e,0;3,e,4;4,e,11;5,e,6;6,e,7;6,e,9;7,k,8;8,e,7;8,e,9;9,e,11;10,e,3;10,e,5#10#11");
		assertEquals("-1;0/2/4/11;0/3/4/5/6/7/9/10/11;1;7/8/9/11#k;n;w#-1,k,-1;-1,n,-1;-1,w,-1;0/2/4/11,k,-1;0/2/4/11,n,-1;0/2/4/11,w,1;0/3/4/5/6/7/9/10/11,k,7/8/9/11;0/3/4/5/6/7/9/10/11,n,-1;0/3/4/5/6/7/9/10/11,w,1;1,k,-1;1,n,0/2/4/11;1,w,-1;7/8/9/11,k,7/8/9/11;7/8/9/11,n,-1;7/8/9/11,w,-1#0/3/4/5/6/7/9/10/11#0/2/4/11;0/3/4/5/6/7/9/10/11;7/8/9/11", nfaToDfa.toString());
	}

	@Test
	public void testNfa8() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8;9#g;n;y#0,g,1;1,e,0;1,e,3;2,e,0;2,e,3;3,y,4;4,n,5;5,e,6;5,e,9;6,y,7;7,y,8;8,e,6;8,e,9#2#9");
		assertEquals("-1;0/1/3;0/2/3;4;5/6/9;6/8/9;7#g;n;y#-1,g,-1;-1,n,-1;-1,y,-1;0/1/3,g,0/1/3;0/1/3,n,-1;0/1/3,y,4;0/2/3,g,0/1/3;0/2/3,n,-1;0/2/3,y,4;4,g,-1;4,n,5/6/9;4,y,-1;5/6/9,g,-1;5/6/9,n,-1;5/6/9,y,7;6/8/9,g,-1;6/8/9,n,-1;6/8/9,y,7;7,g,-1;7,n,-1;7,y,6/8/9#0/2/3#5/6/9;6/8/9", nfaToDfa.toString());
	}

	@Test
	public void testNfa9() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6#a;d;h;q#0,q,1;1,e,2;1,e,4;2,a,3;3,e,2;3,e,4;4,d,5;5,h,6#0#6");
		assertEquals("-1;0;1/2/4;2/3/4;5;6#a;d;h;q#-1,a,-1;-1,d,-1;-1,h,-1;-1,q,-1;0,a,-1;0,d,-1;0,h,-1;0,q,1/2/4;1/2/4,a,2/3/4;1/2/4,d,5;1/2/4,h,-1;1/2/4,q,-1;2/3/4,a,2/3/4;2/3/4,d,5;2/3/4,h,-1;2/3/4,q,-1;5,a,-1;5,d,-1;5,h,6;5,q,-1;6,a,-1;6,d,-1;6,h,-1;6,q,-1#0#6", nfaToDfa.toString());
	}

	@Test
	public void testNfa10() {
		NfaToDfa nfaToDfa= new NfaToDfa("0;1;2;3;4;5;6;7;8;9#o;p;q#0,q,1;1,e,6;1,e,8;2,p,3;3,e,7;4,e,5;5,e,7;6,e,2;6,e,4;7,e,6;7,e,8;8,o,9#0#9");
		assertEquals("-1;0;1/2/4/5/6/7/8;2/3/4/5/6/7/8;9#o;p;q#-1,o,-1;-1,p,-1;-1,q,-1;0,o,-1;0,p,-1;0,q,1/2/4/5/6/7/8;1/2/4/5/6/7/8,o,9;1/2/4/5/6/7/8,p,2/3/4/5/6/7/8;1/2/4/5/6/7/8,q,-1;2/3/4/5/6/7/8,o,9;2/3/4/5/6/7/8,p,2/3/4/5/6/7/8;2/3/4/5/6/7/8,q,-1;9,o,-1;9,p,-1;9,q,-1#0#9", nfaToDfa.toString());
	}

}
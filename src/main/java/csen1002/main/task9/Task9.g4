
/**
 * Write your info here
 *
 * @name Mahmoud Mohamed Aly Abdallah Jobeel
 * @id 46-18406
 * @labNumber 020
 */


/*
s −→ a1 c1 b1 c1.l = a1.n2; c1.u = a1.n3 c1.ilf = 0; c1.iuf = 1 s.check = c1.slf ∗ c1.suf ∗ equals(a1.n, b1.n)
a1 −→ a a2 a1.n = a2.n + 1; a1.n2 = a2.n2 ∗ 2; a1.n3 = a2.n3 ∗ 3
a1 −→ ε a1.n = 0; a1.n2 = 1; a1.n3 = 1
b1 −→ b b2 b1.n = b2.n + 1
b1 −→ ε b1.n = 0
c1 −→ c c2 c2.l = c1.l; c2.u = c1.u c2.ilf = c1.ilf; c2.iuf = c1.iuf c1.m = c2.m + 1 c1.slf = c2.slf + equals(c1.l, c1.m) c1.suf = c2.suf − equals(c1.u, c2.m)
c1 −→ ε c1.m = 0; c1.slf = c1.ilf; c1.suf = c1.iuf
*/

grammar Task9;

@members {
	/**
	 * Compares two integer numbers
	 *
	 * @param x the first number to compare
	 * @param y the second number to compare
	 * @return 1 if x is equal to y, and 0 otherwise
	 */
	public static int equals(int x, int y) {
	    return x == y ? 1 : 0;
	}
}

s returns [int check]
    : a1 c1[$a1.n2,$a1.n3,0,1] b1 { $check = $c1.slf * $c1.suf * equals($a1.n, $b1.n); }
    ;

a1 returns [int n, int n2, int n3]
    : 'a' a2=a1 { $n = $a2.n + 1; $n2 = $a2.n2 * 2; $n3 = $a2.n3 * 3; }
    | { $n = 0; $n2 = 1; $n3 = 1; }
    ;

b1 returns [int n]
    : 'b' b2=b1 { $n = $b2.n + 1; }
    | { $n = 0; }
    ;

c1 [int l, int u, int ilf, int iuf] returns [int m, int slf, int suf]
    : 'c' c2=c1[$l,$u,$ilf,$iuf] { $m = $c2.m + 1; $slf = $c2.slf + equals($l, $m); $suf = $c2.suf - equals($u, $c2.m); }
    | { $m = 0; $slf = $ilf; $suf = $iuf; }
    ;






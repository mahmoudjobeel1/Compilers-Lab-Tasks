// Generated from C:/Users/lenovo/IdeaProjects/ACL/src/main/java/csen1002/main/task9\Task9.g4 by ANTLR 4.12.0
package csen1002.main.task9;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Task9Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3;
	public static final int
		RULE_s = 0, RULE_a1 = 1, RULE_b1 = 2, RULE_c1 = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "a1", "b1", "c1"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'a'", "'b'", "'c'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Task9.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public Task9Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public int check;
		public A1Context a1;
		public C1Context c1;
		public B1Context b1;
		public A1Context a1() {
			return getRuleContext(A1Context.class,0);
		}
		public C1Context c1() {
			return getRuleContext(C1Context.class,0);
		}
		public B1Context b1() {
			return getRuleContext(B1Context.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task9Visitor ) return ((Task9Visitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			((SContext)_localctx).a1 = a1();
			setState(9);
			((SContext)_localctx).c1 = c1(((SContext)_localctx).a1.n2,((SContext)_localctx).a1.n3,0,1);
			setState(10);
			((SContext)_localctx).b1 = b1();
			 ((SContext)_localctx).check =  ((SContext)_localctx).c1.slf * ((SContext)_localctx).c1.suf * equals(((SContext)_localctx).a1.n, ((SContext)_localctx).b1.n); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class A1Context extends ParserRuleContext {
		public int n;
		public int n2;
		public int n3;
		public A1Context a2;
		public A1Context a1() {
			return getRuleContext(A1Context.class,0);
		}
		public A1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).enterA1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).exitA1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task9Visitor ) return ((Task9Visitor<? extends T>)visitor).visitA1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final A1Context a1() throws RecognitionException {
		A1Context _localctx = new A1Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_a1);
		try {
			setState(18);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(T__0);
				setState(14);
				((A1Context)_localctx).a2 = a1();
				 ((A1Context)_localctx).n =  ((A1Context)_localctx).a2.n + 1; ((A1Context)_localctx).n2 =  ((A1Context)_localctx).a2.n2 * 2; ((A1Context)_localctx).n3 =  ((A1Context)_localctx).a2.n3 * 3; 
				}
				break;
			case EOF:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				 ((A1Context)_localctx).n =  0; ((A1Context)_localctx).n2 =  1; ((A1Context)_localctx).n3 =  1; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class B1Context extends ParserRuleContext {
		public int n;
		public B1Context b2;
		public B1Context b1() {
			return getRuleContext(B1Context.class,0);
		}
		public B1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).enterB1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).exitB1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task9Visitor ) return ((Task9Visitor<? extends T>)visitor).visitB1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final B1Context b1() throws RecognitionException {
		B1Context _localctx = new B1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_b1);
		try {
			setState(25);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(T__1);
				setState(21);
				((B1Context)_localctx).b2 = b1();
				 ((B1Context)_localctx).n =  ((B1Context)_localctx).b2.n + 1; 
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				 ((B1Context)_localctx).n =  0; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class C1Context extends ParserRuleContext {
		public int l;
		public int u;
		public int ilf;
		public int iuf;
		public int m;
		public int slf;
		public int suf;
		public C1Context c2;
		public C1Context c1() {
			return getRuleContext(C1Context.class,0);
		}
		public C1Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public C1Context(ParserRuleContext parent, int invokingState, int l, int u, int ilf, int iuf) {
			super(parent, invokingState);
			this.l = l;
			this.u = u;
			this.ilf = ilf;
			this.iuf = iuf;
		}
		@Override public int getRuleIndex() { return RULE_c1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).enterC1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task9Listener ) ((Task9Listener)listener).exitC1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task9Visitor ) return ((Task9Visitor<? extends T>)visitor).visitC1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final C1Context c1(int l,int u,int ilf,int iuf) throws RecognitionException {
		C1Context _localctx = new C1Context(_ctx, getState(), l, u, ilf, iuf);
		enterRule(_localctx, 6, RULE_c1);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(T__2);
				setState(28);
				((C1Context)_localctx).c2 = c1(_localctx.l,_localctx.u,_localctx.ilf,_localctx.iuf);
				 ((C1Context)_localctx).m =  ((C1Context)_localctx).c2.m + 1; ((C1Context)_localctx).slf =  ((C1Context)_localctx).c2.slf + equals(_localctx.l, _localctx.m); ((C1Context)_localctx).suf =  ((C1Context)_localctx).c2.suf - equals(_localctx.u, ((C1Context)_localctx).c2.m); 
				}
				break;
			case EOF:
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 ((C1Context)_localctx).m =  0; ((C1Context)_localctx).slf =  _localctx.ilf; ((C1Context)_localctx).suf =  _localctx.iuf; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0003#\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u0013\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u001a\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003!\b\u0003\u0001"+
		"\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000!\u0000\b"+
		"\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000\u0004\u0019"+
		"\u0001\u0000\u0000\u0000\u0006 \u0001\u0000\u0000\u0000\b\t\u0003\u0002"+
		"\u0001\u0000\t\n\u0003\u0006\u0003\u0000\n\u000b\u0003\u0004\u0002\u0000"+
		"\u000b\f\u0006\u0000\uffff\uffff\u0000\f\u0001\u0001\u0000\u0000\u0000"+
		"\r\u000e\u0005\u0001\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f"+
		"\u0010\u0006\u0001\uffff\uffff\u0000\u0010\u0013\u0001\u0000\u0000\u0000"+
		"\u0011\u0013\u0006\u0001\uffff\uffff\u0000\u0012\r\u0001\u0000\u0000\u0000"+
		"\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0003\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0016\u0003\u0004\u0002\u0000"+
		"\u0016\u0017\u0006\u0002\uffff\uffff\u0000\u0017\u001a\u0001\u0000\u0000"+
		"\u0000\u0018\u001a\u0006\u0002\uffff\uffff\u0000\u0019\u0014\u0001\u0000"+
		"\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u0005\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0005\u0003\u0000\u0000\u001c\u001d\u0003\u0006"+
		"\u0003\u0000\u001d\u001e\u0006\u0003\uffff\uffff\u0000\u001e!\u0001\u0000"+
		"\u0000\u0000\u001f!\u0006\u0003\uffff\uffff\u0000 \u001b\u0001\u0000\u0000"+
		"\u0000 \u001f\u0001\u0000\u0000\u0000!\u0007\u0001\u0000\u0000\u0000\u0003"+
		"\u0012\u0019 ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
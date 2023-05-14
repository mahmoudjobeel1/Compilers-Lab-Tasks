// Generated from C:/Users/lenovo/IdeaProjects/ACL/src/main/java/csen1002/main/task8\Task8.g4 by ANTLR 4.12.0
package csen1002.main.task8;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Task8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Space=1, LP=2, RP=3, COMP=4, LIT=5, NUM=6, ELSE=7, IF=8, ID=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Digit", "Integer", "Decimal", "E", "Sign", "Exponent", "Letter", "Underscore", 
			"Space", "LP", "RP", "COMP", "LIT", "NUM", "ELSE", "IF", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Space", "LP", "RP", "COMP", "LIT", "NUM", "ELSE", "IF", "ID"
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


	public Task8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Task8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\t\u0081\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0004\u0001\'\b\u0001\u000b\u0001\f\u0001(\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0003\u00055\b\u0005\u0001\u0005\u0004\u0005"+
		"8\b\u0005\u000b\u0005\f\u00059\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0004\bA\b\b\u000b\b\f\bB\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bT\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\fZ\b\f\n\f\f\f]\t\f\u0001"+
		"\f\u0001\f\u0001\r\u0003\rb\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\rl\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0003\u0010x\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010}\b\u0010\n\u0010\f\u0010\u0080\t\u0010\u0000\u0000"+
		"\u0011\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0000\t\u0000\u000b\u0000"+
		"\r\u0000\u000f\u0000\u0011\u0001\u0013\u0002\u0015\u0003\u0017\u0004\u0019"+
		"\u0005\u001b\u0006\u001d\u0007\u001f\b!\t\u0001\u0000\u000b\u0001\u0000"+
		"09\u0002\u0000EEee\u0002\u0000++--\u0002\u0000AZaz\u0003\u0000\t\n\r\r"+
		"  \u0002\u0000<<>>\u0002\u0000\"\"\\\\\u0002\u0000LLll\u0002\u0000SSs"+
		"s\u0002\u0000IIii\u0002\u0000FFff\u008a\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0001#\u0001\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005*"+
		"\u0001\u0000\u0000\u0000\u0007.\u0001\u0000\u0000\u0000\t0\u0001\u0000"+
		"\u0000\u0000\u000b2\u0001\u0000\u0000\u0000\r;\u0001\u0000\u0000\u0000"+
		"\u000f=\u0001\u0000\u0000\u0000\u0011@\u0001\u0000\u0000\u0000\u0013F"+
		"\u0001\u0000\u0000\u0000\u0015H\u0001\u0000\u0000\u0000\u0017S\u0001\u0000"+
		"\u0000\u0000\u0019U\u0001\u0000\u0000\u0000\u001ba\u0001\u0000\u0000\u0000"+
		"\u001dm\u0001\u0000\u0000\u0000\u001fr\u0001\u0000\u0000\u0000!w\u0001"+
		"\u0000\u0000\u0000#$\u0007\u0000\u0000\u0000$\u0002\u0001\u0000\u0000"+
		"\u0000%\'\u0003\u0001\u0000\u0000&%\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\u0004"+
		"\u0001\u0000\u0000\u0000*+\u0003\u0003\u0001\u0000+,\u0005.\u0000\u0000"+
		",-\u0003\u0003\u0001\u0000-\u0006\u0001\u0000\u0000\u0000./\u0007\u0001"+
		"\u0000\u0000/\b\u0001\u0000\u0000\u000001\u0007\u0002\u0000\u00001\n\u0001"+
		"\u0000\u0000\u000024\u0003\u0007\u0003\u000035\u0003\t\u0004\u000043\u0001"+
		"\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u0000"+
		"68\u0003\u0001\u0000\u000076\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:\f\u0001\u0000"+
		"\u0000\u0000;<\u0007\u0003\u0000\u0000<\u000e\u0001\u0000\u0000\u0000"+
		"=>\u0005_\u0000\u0000>\u0010\u0001\u0000\u0000\u0000?A\u0007\u0004\u0000"+
		"\u0000@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006"+
		"\b\u0000\u0000E\u0012\u0001\u0000\u0000\u0000FG\u0005(\u0000\u0000G\u0014"+
		"\u0001\u0000\u0000\u0000HI\u0005)\u0000\u0000I\u0016\u0001\u0000\u0000"+
		"\u0000JT\u0007\u0005\u0000\u0000KL\u0005<\u0000\u0000LT\u0005=\u0000\u0000"+
		"MN\u0005>\u0000\u0000NT\u0005=\u0000\u0000OP\u0005=\u0000\u0000PT\u0005"+
		"=\u0000\u0000QR\u0005!\u0000\u0000RT\u0005=\u0000\u0000SJ\u0001\u0000"+
		"\u0000\u0000SK\u0001\u0000\u0000\u0000SM\u0001\u0000\u0000\u0000SO\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000T\u0018\u0001\u0000\u0000"+
		"\u0000U[\u0005\"\u0000\u0000VZ\b\u0006\u0000\u0000WX\u0005\\\u0000\u0000"+
		"XZ\u0007\u0006\u0000\u0000YV\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005"+
		"\"\u0000\u0000_\u001a\u0001\u0000\u0000\u0000`b\u0003\t\u0004\u0000a`"+
		"\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bk\u0001\u0000\u0000"+
		"\u0000cl\u0003\u0005\u0002\u0000dl\u0003\u0003\u0001\u0000ef\u0003\u0005"+
		"\u0002\u0000fg\u0003\u000b\u0005\u0000gl\u0001\u0000\u0000\u0000hi\u0003"+
		"\u0003\u0001\u0000ij\u0003\u000b\u0005\u0000jl\u0001\u0000\u0000\u0000"+
		"kc\u0001\u0000\u0000\u0000kd\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000"+
		"\u0000kh\u0001\u0000\u0000\u0000l\u001c\u0001\u0000\u0000\u0000mn\u0007"+
		"\u0001\u0000\u0000no\u0007\u0007\u0000\u0000op\u0007\b\u0000\u0000pq\u0007"+
		"\u0001\u0000\u0000q\u001e\u0001\u0000\u0000\u0000rs\u0007\t\u0000\u0000"+
		"st\u0007\n\u0000\u0000t \u0001\u0000\u0000\u0000ux\u0003\r\u0006\u0000"+
		"vx\u0003\u000f\u0007\u0000wu\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000"+
		"\u0000x~\u0001\u0000\u0000\u0000y}\u0003\r\u0006\u0000z}\u0003\u0001\u0000"+
		"\u0000{}\u0003\u000f\u0007\u0000|y\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\"\u0001"+
		"\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\r\u0000(49BSY[akw|~"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
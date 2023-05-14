// Make Sure that the package is "csen1002.main.task8"
package csen1002.main.task8;

// Make sure that ANTLR is imported properly

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

import java.util.List;
import java.util.StringJoiner;

// This file is just to test your code (DO NOT SUBMIT THIS FILE)
public class Task8Runner {

    /**
     * Returns a string of tokenized lexemes.
     *
     * @param input is the string to be tokenized.
     * @return Returns a formatted string representation of the list of tokens. The
     *         string representation follows the one in the task description
     */
    public static String tokenStream(String input) {
        // In case Task8Lexer is not defined correctly:
        // 1- If you modified the grammar in the g4 file, regenerate the ANTLR
        // recognizer to make sure that the latest grammar is generated
        // 2- Make sure that the location and the package are configured properly
        Task8Lexer lexer = new Task8Lexer(CharStreams.fromString(input));
        Vocabulary vocabulary = lexer.getVocabulary();
        List<? extends Token> tokens = lexer.getAllTokens();
        StringJoiner stringJoiner = new StringJoiner(";");
        for (Token token : tokens) {
            stringJoiner.add(token.getText() + "," + vocabulary.getSymbolicName(token.getType()));
        }
        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        String input=")) (!=(   if   ElsE    JYw2z   ==   ==  ELSE      ElSE   cefcxbuq     1E-10\"~A~Y \"mGiFvdY   ElsE jhbp84R3 9923996( (  IF)   ))    KZhNAJclQKI      eLSe      iF      IF      IF  046515   elSE(  !=     IF If  <=(6891889221842E8869iF<=321591e739454==q5BOKDYR38URbb!=<=If   eLSE)   ELsE      RnOboof   7.03082278     \"Mp}v#\"    \"\\\"4\"  eLSE>  \"< %tyNU\"   \"\\\"\\\"\"    ElsE   If\"y-~j`\"    \"\\\\`\"iGXiD IF k9lgHI () )4!=2150E+672)(    (  (!=hvc  \"\"   a_  ElsE)     07861273008554yJaIgBe4Bw1t     )      9258583601098505433.6    (iF)   >)    If     ELsE(15.22551070910\"6($+Zc\"====(     )    129814153602.0224else\"`\\\"\"9071330    if      iF\"e0)J)2\"    Else\"i\\\"Ly\"KTb  IF Q7im  iF   if \"SapFuG\"  Else      8.7754969236643     (   ==   96321265e-3646";
        String output="),RP;),RP;(,LP;!=,COMP;(,LP;if,IF;ElsE,ELSE;JYw2z,ID;==,COMP;==,COMP;ELSE,ELSE;ElSE,ELSE;cefcxbuq,ID;1E-10,NUM;\"~A~Y \",LIT;mGiFvdY,ID;ElsE,ELSE;jhbp84R3,ID;9923996,NUM;(,LP;(,LP;IF,IF;),RP;),RP;),RP;KZhNAJclQKI,ID;eLSe,ELSE;iF,IF;IF,IF;IF,IF;046515,NUM;elSE,ELSE;(,LP;!=,COMP;IF,IF;If,IF;<=,COMP;(,LP;6891889221842E8869,NUM;iF,IF;<=,COMP;321591e739454,NUM;==,COMP;q5BOKDYR38URbb,ID;!=,COMP;<=,COMP;If,IF;eLSE,ELSE;),RP;ELsE,ELSE;RnOboof,ID;7.03082278,NUM;\"Mp}v#\",LIT;\"\\\"4\",LIT;eLSE,ELSE;>,COMP;\"< %tyNU\",LIT;\"\\\"\\\"\",LIT;ElsE,ELSE;If,IF;\"y-~j`\",LIT;\"\\\\`\",LIT;iGXiD,ID;IF,IF;k9lgHI,ID;(,LP;),RP;),RP;4,NUM;!=,COMP;2150E+672,NUM;),RP;(,LP;(,LP;(,LP;!=,COMP;hvc,ID;\"\",LIT;a_,ID;ElsE,ELSE;),RP;07861273008554,NUM;yJaIgBe4Bw1t,ID;),RP;9258583601098505433.6,NUM;(,LP;iF,IF;),RP;>,COMP;),RP;If,IF;ELsE,ELSE;(,LP;15.22551070910,NUM;\"6($+Zc\",LIT;==,COMP;==,COMP;(,LP;),RP;129814153602.0224,NUM;else,ELSE;\"`\\\"\",LIT;9071330,NUM;if,IF;iF,IF;\"e0)J)2\",LIT;Else,ELSE;\"i\\\"Ly\",LIT;KTb,ID;IF,IF;Q7im,ID;iF,IF;if,IF;\"SapFuG\",LIT;Else,ELSE;8.7754969236643,NUM;(,LP;==,COMP;96321265e-3646,NUM";
        System.out.println(tokenStream(input));
        System.out.println(output);

    }

}

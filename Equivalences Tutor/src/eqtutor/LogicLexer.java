// $ANTLR 3.4 /homes/sdj09/LogicLexer.g 2013-06-21 10:12:09

  package eqtutor;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int COMMA=5;
    public static final int EXISTS=6;
    public static final int FALSITY=7;
    public static final int FORALL=8;
    public static final int ID=9;
    public static final int IFF=10;
    public static final int IFTHEN=11;
    public static final int LPAREN=12;
    public static final int NOT=13;
    public static final int OR=14;
    public static final int RPAREN=15;
    public static final int TRUTH=16;
    public static final int WHITESPACE=17;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public LogicLexer() {} 
    public LogicLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/homes/sdj09/LogicLexer.g"; }

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:11:11: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /homes/sdj09/LogicLexer.g:11:17: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /homes/sdj09/LogicLexer.g:11:17: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /homes/sdj09/LogicLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:13:5: ( '&' )
            // /homes/sdj09/LogicLexer.g:13:7: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:14:4: ( '|' )
            // /homes/sdj09/LogicLexer.g:14:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "IFTHEN"
    public final void mIFTHEN() throws RecognitionException {
        try {
            int _type = IFTHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:15:8: ( '->' )
            // /homes/sdj09/LogicLexer.g:15:10: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFTHEN"

    // $ANTLR start "IFF"
    public final void mIFF() throws RecognitionException {
        try {
            int _type = IFF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:16:6: ( '<>' )
            // /homes/sdj09/LogicLexer.g:16:8: '<>'
            {
            match("<>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFF"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:18:6: ( '!' )
            // /homes/sdj09/LogicLexer.g:18:8: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:20:9: ( '(' )
            // /homes/sdj09/LogicLexer.g:20:11: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:21:9: ( ')' )
            // /homes/sdj09/LogicLexer.g:21:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:23:4: ( ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' )* )
            // /homes/sdj09/LogicLexer.g:23:6: ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /homes/sdj09/LogicLexer.g:23:26: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /homes/sdj09/LogicLexer.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "FORALL"
    public final void mFORALL() throws RecognitionException {
        try {
            int _type = FORALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:25:9: ( '(A)' )
            // /homes/sdj09/LogicLexer.g:25:11: '(A)'
            {
            match("(A)"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FORALL"

    // $ANTLR start "EXISTS"
    public final void mEXISTS() throws RecognitionException {
        try {
            int _type = EXISTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:26:9: ( '(E)' )
            // /homes/sdj09/LogicLexer.g:26:11: '(E)'
            {
            match("(E)"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXISTS"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:27:7: ( ',' )
            // /homes/sdj09/LogicLexer.g:27:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "TRUTH"
    public final void mTRUTH() throws RecognitionException {
        try {
            int _type = TRUTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:28:9: ( '(T)' )
            // /homes/sdj09/LogicLexer.g:28:11: '(T)'
            {
            match("(T)"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUTH"

    // $ANTLR start "FALSITY"
    public final void mFALSITY() throws RecognitionException {
        try {
            int _type = FALSITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /homes/sdj09/LogicLexer.g:29:9: ( '(B)' )
            // /homes/sdj09/LogicLexer.g:29:11: '(B)'
            {
            match("(B)"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSITY"

    public void mTokens() throws RecognitionException {
        // /homes/sdj09/LogicLexer.g:1:8: ( WHITESPACE | AND | OR | IFTHEN | IFF | NOT | LPAREN | RPAREN | ID | FORALL | EXISTS | COMMA | TRUTH | FALSITY )
        int alt3=14;
        switch ( input.LA(1) ) {
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt3=1;
            }
            break;
        case '&':
            {
            alt3=2;
            }
            break;
        case '|':
            {
            alt3=3;
            }
            break;
        case '-':
            {
            alt3=4;
            }
            break;
        case '<':
            {
            alt3=5;
            }
            break;
        case '!':
            {
            alt3=6;
            }
            break;
        case '(':
            {
            switch ( input.LA(2) ) {
            case 'A':
                {
                alt3=10;
                }
                break;
            case 'E':
                {
                alt3=11;
                }
                break;
            case 'T':
                {
                alt3=13;
                }
                break;
            case 'B':
                {
                alt3=14;
                }
                break;
            default:
                alt3=7;
            }

            }
            break;
        case ')':
            {
            alt3=8;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=9;
            }
            break;
        case ',':
            {
            alt3=12;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // /homes/sdj09/LogicLexer.g:1:10: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 2 :
                // /homes/sdj09/LogicLexer.g:1:21: AND
                {
                mAND(); 


                }
                break;
            case 3 :
                // /homes/sdj09/LogicLexer.g:1:25: OR
                {
                mOR(); 


                }
                break;
            case 4 :
                // /homes/sdj09/LogicLexer.g:1:28: IFTHEN
                {
                mIFTHEN(); 


                }
                break;
            case 5 :
                // /homes/sdj09/LogicLexer.g:1:35: IFF
                {
                mIFF(); 


                }
                break;
            case 6 :
                // /homes/sdj09/LogicLexer.g:1:39: NOT
                {
                mNOT(); 


                }
                break;
            case 7 :
                // /homes/sdj09/LogicLexer.g:1:43: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 8 :
                // /homes/sdj09/LogicLexer.g:1:50: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 9 :
                // /homes/sdj09/LogicLexer.g:1:57: ID
                {
                mID(); 


                }
                break;
            case 10 :
                // /homes/sdj09/LogicLexer.g:1:60: FORALL
                {
                mFORALL(); 


                }
                break;
            case 11 :
                // /homes/sdj09/LogicLexer.g:1:67: EXISTS
                {
                mEXISTS(); 


                }
                break;
            case 12 :
                // /homes/sdj09/LogicLexer.g:1:74: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 13 :
                // /homes/sdj09/LogicLexer.g:1:80: TRUTH
                {
                mTRUTH(); 


                }
                break;
            case 14 :
                // /homes/sdj09/LogicLexer.g:1:86: FALSITY
                {
                mFALSITY(); 


                }
                break;

        }

    }


 

}
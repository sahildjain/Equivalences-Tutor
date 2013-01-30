// $ANTLR 3.4 /homes/sdj09/LogicParser.g 2013-01-30 14:51:02

  package eqtutor;
  
  import java.util.LinkedList;
  import java.util.List;
  import AST.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ID", "IFF", "IFTHEN", "LPAREN", "NOT", "OR", "RPAREN", "WHITESPACE"
    };

    public static final int EOF=-1;
    public static final int AND=4;
    public static final int ID=5;
    public static final int IFF=6;
    public static final int IFTHEN=7;
    public static final int LPAREN=8;
    public static final int NOT=9;
    public static final int OR=10;
    public static final int RPAREN=11;
    public static final int WHITESPACE=12;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public LogicParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return LogicParser.tokenNames; }
    public String getGrammarFileName() { return "/homes/sdj09/LogicParser.g"; }


      private boolean hasFoundError = false;
      
      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        hasFoundError = true;
      }
      
      public boolean hasFoundError() {
        return this.hasFoundError;
      }



    // $ANTLR start "program"
    // /homes/sdj09/LogicParser.g:27:1: program returns [AST tree] : e= iffexpr EOF ;
    public final AST program() throws RecognitionException {
        AST tree = null;


        ASTPropositionalNode e =null;


        try {
            // /homes/sdj09/LogicParser.g:28:3: (e= iffexpr EOF )
            // /homes/sdj09/LogicParser.g:28:5: e= iffexpr EOF
            {
            pushFollow(FOLLOW_iffexpr_in_program48);
            e=iffexpr();

            state._fsp--;


            tree = new AST(new ASTProgramNode(e));

            match(input,EOF,FOLLOW_EOF_in_program52); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return tree;
    }
    // $ANTLR end "program"



    // $ANTLR start "iffexpr"
    // /homes/sdj09/LogicParser.g:31:1: iffexpr returns [ASTPropositionalNode node] : ifthen= ifexpr ( IFF iff= iffexpr )* ;
    public final ASTPropositionalNode iffexpr() throws RecognitionException {
        ASTPropositionalNode node = null;


        ASTPropositionalNode ifthen =null;

        ASTPropositionalNode iff =null;


        try {
            // /homes/sdj09/LogicParser.g:32:3: (ifthen= ifexpr ( IFF iff= iffexpr )* )
            // /homes/sdj09/LogicParser.g:32:5: ifthen= ifexpr ( IFF iff= iffexpr )*
            {
            pushFollow(FOLLOW_ifexpr_in_iffexpr73);
            ifthen=ifexpr();

            state._fsp--;


            node = ifthen;

            // /homes/sdj09/LogicParser.g:32:45: ( IFF iff= iffexpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IFF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:32:46: IFF iff= iffexpr
            	    {
            	    match(input,IFF,FOLLOW_IFF_in_iffexpr78); 

            	    pushFollow(FOLLOW_iffexpr_in_iffexpr84);
            	    iff=iffexpr();

            	    state._fsp--;


            	    node = new ASTIffNode(ifthen, iff);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "iffexpr"



    // $ANTLR start "ifexpr"
    // /homes/sdj09/LogicParser.g:35:1: ifexpr returns [ASTPropositionalNode node] : or= orexpr ( IFTHEN ifthen= ifexpr )* ;
    public final ASTPropositionalNode ifexpr() throws RecognitionException {
        ASTPropositionalNode node = null;


        ASTPropositionalNode or =null;

        ASTPropositionalNode ifthen =null;


        try {
            // /homes/sdj09/LogicParser.g:36:3: (or= orexpr ( IFTHEN ifthen= ifexpr )* )
            // /homes/sdj09/LogicParser.g:36:5: or= orexpr ( IFTHEN ifthen= ifexpr )*
            {
            pushFollow(FOLLOW_orexpr_in_ifexpr112);
            or=orexpr();

            state._fsp--;


            node = or;

            // /homes/sdj09/LogicParser.g:36:37: ( IFTHEN ifthen= ifexpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IFTHEN) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:36:38: IFTHEN ifthen= ifexpr
            	    {
            	    match(input,IFTHEN,FOLLOW_IFTHEN_in_ifexpr117); 

            	    pushFollow(FOLLOW_ifexpr_in_ifexpr123);
            	    ifthen=ifexpr();

            	    state._fsp--;


            	    node = new ASTIfThenNode(or, ifthen);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "ifexpr"



    // $ANTLR start "orexpr"
    // /homes/sdj09/LogicParser.g:39:1: orexpr returns [ASTPropositionalNode node] : and= andexpr ( OR or= orexpr )* ;
    public final ASTPropositionalNode orexpr() throws RecognitionException {
        ASTPropositionalNode node = null;


        ASTPropositionalNode and =null;

        ASTPropositionalNode or =null;


        try {
            // /homes/sdj09/LogicParser.g:40:3: (and= andexpr ( OR or= orexpr )* )
            // /homes/sdj09/LogicParser.g:40:5: and= andexpr ( OR or= orexpr )*
            {
            pushFollow(FOLLOW_andexpr_in_orexpr148);
            and=andexpr();

            state._fsp--;


            node = and;

            // /homes/sdj09/LogicParser.g:40:40: ( OR or= orexpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==OR) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:40:41: OR or= orexpr
            	    {
            	    match(input,OR,FOLLOW_OR_in_orexpr153); 

            	    pushFollow(FOLLOW_orexpr_in_orexpr159);
            	    or=orexpr();

            	    state._fsp--;


            	    node = new ASTOrNode(and, or);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "orexpr"



    // $ANTLR start "andexpr"
    // /homes/sdj09/LogicParser.g:43:1: andexpr returns [ASTPropositionalNode node] : not= notexpr ( AND and= andexpr )* ;
    public final ASTPropositionalNode andexpr() throws RecognitionException {
        ASTPropositionalNode node = null;


        ASTPropositionalNode not =null;

        ASTPropositionalNode and =null;


        try {
            // /homes/sdj09/LogicParser.g:44:3: (not= notexpr ( AND and= andexpr )* )
            // /homes/sdj09/LogicParser.g:44:5: not= notexpr ( AND and= andexpr )*
            {
            pushFollow(FOLLOW_notexpr_in_andexpr184);
            not=notexpr();

            state._fsp--;


            node = not;

            // /homes/sdj09/LogicParser.g:44:40: ( AND and= andexpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==AND) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:44:41: AND and= andexpr
            	    {
            	    match(input,AND,FOLLOW_AND_in_andexpr189); 

            	    pushFollow(FOLLOW_andexpr_in_andexpr195);
            	    and=andexpr();

            	    state._fsp--;


            	    node = new ASTAndNode(not, and);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "andexpr"



    // $ANTLR start "notexpr"
    // /homes/sdj09/LogicParser.g:47:1: notexpr returns [ASTPropositionalNode node] : ( NOT not= notexpr |id= identifier );
    public final ASTPropositionalNode notexpr() throws RecognitionException {
        ASTPropositionalNode node = null;


        ASTPropositionalNode not =null;

        ASTPropositionalNode id =null;


        try {
            // /homes/sdj09/LogicParser.g:48:3: ( NOT not= notexpr |id= identifier )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NOT) ) {
                alt5=1;
            }
            else if ( (LA5_0==ID||LA5_0==LPAREN) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:48:5: NOT not= notexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notexpr218); 

                    pushFollow(FOLLOW_notexpr_in_notexpr224);
                    not=notexpr();

                    state._fsp--;


                    node = new ASTNotNode(not);

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:49:5: id= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_notexpr236);
                    id=identifier();

                    state._fsp--;


                    node = id;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "notexpr"



    // $ANTLR start "identifier"
    // /homes/sdj09/LogicParser.g:52:1: identifier returns [ASTPropositionalNode node] : ( ID | LPAREN iffexpr RPAREN );
    public final ASTPropositionalNode identifier() throws RecognitionException {
        ASTPropositionalNode node = null;


        Token ID1=null;
        ASTPropositionalNode iffexpr2 =null;


        try {
            // /homes/sdj09/LogicParser.g:53:3: ( ID | LPAREN iffexpr RPAREN )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==LPAREN) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:53:5: ID
                    {
                    ID1=(Token)match(input,ID,FOLLOW_ID_in_identifier255); 

                    node = new ASTIdentifierNode((ID1!=null?ID1.getText():null));

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:54:5: LPAREN iffexpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_identifier263); 

                    pushFollow(FOLLOW_iffexpr_in_identifier265);
                    iffexpr2=iffexpr();

                    state._fsp--;


                    match(input,RPAREN,FOLLOW_RPAREN_in_identifier267); 

                    node = iffexpr2;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "identifier"

    // Delegated rules


 

    public static final BitSet FOLLOW_iffexpr_in_program48 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program52 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifexpr_in_iffexpr73 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IFF_in_iffexpr78 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_iffexpr_in_iffexpr84 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_orexpr_in_ifexpr112 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_IFTHEN_in_ifexpr117 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_ifexpr_in_ifexpr123 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_andexpr_in_orexpr148 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_OR_in_orexpr153 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_orexpr_in_orexpr159 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_notexpr_in_andexpr184 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_andexpr189 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_andexpr_in_andexpr195 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_notexpr218 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_notexpr_in_notexpr224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_notexpr236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_identifier263 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_iffexpr_in_identifier265 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_identifier267 = new BitSet(new long[]{0x0000000000000002L});

}
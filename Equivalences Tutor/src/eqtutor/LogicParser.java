// $ANTLR 3.4 /homes/sdj09/LogicParser.g 2013-06-21 10:12:14

  package eqtutor;
  
  import java.util.LinkedList;
  import java.util.List;
  import AST.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "COMMA", "EXISTS", "FALSITY", "FORALL", "ID", "IFF", "IFTHEN", "LPAREN", "NOT", "OR", "RPAREN", "TRUTH", "WHITESPACE"
    };

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
      
      private int counter = 0;
      
      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        hasFoundError = true;
      }
      
      public boolean hasFoundError() {
        return this.hasFoundError;
      }



    // $ANTLR start "program"
    // /homes/sdj09/LogicParser.g:30:1: program returns [AST tree] : e= iffexpr EOF ;
    public final AST program() throws RecognitionException {
        AST tree = null;


        ASTNode e =null;


        try {
            // /homes/sdj09/LogicParser.g:31:3: (e= iffexpr EOF )
            // /homes/sdj09/LogicParser.g:31:5: e= iffexpr EOF
            {
            pushFollow(FOLLOW_iffexpr_in_program57);
            e=iffexpr();

            state._fsp--;
            if (state.failed) return tree;

            if ( state.backtracking==0 ) {tree = new AST(++counter, new ASTProgramNode(++counter, e));}

            match(input,EOF,FOLLOW_EOF_in_program61); if (state.failed) return tree;

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
    // /homes/sdj09/LogicParser.g:34:1: iffexpr returns [ASTNode node] : ifthen= ifexpr ( IFF iff= iffexpr )* ;
    public final ASTNode iffexpr() throws RecognitionException {
        ASTNode node = null;


        ASTNode ifthen =null;

        ASTNode iff =null;


        try {
            // /homes/sdj09/LogicParser.g:35:3: (ifthen= ifexpr ( IFF iff= iffexpr )* )
            // /homes/sdj09/LogicParser.g:35:5: ifthen= ifexpr ( IFF iff= iffexpr )*
            {
            pushFollow(FOLLOW_ifexpr_in_iffexpr82);
            ifthen=ifexpr();

            state._fsp--;
            if (state.failed) return node;

            if ( state.backtracking==0 ) {node = ifthen;}

            // /homes/sdj09/LogicParser.g:35:45: ( IFF iff= iffexpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IFF) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_LogicParser()) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:35:46: IFF iff= iffexpr
            	    {
            	    match(input,IFF,FOLLOW_IFF_in_iffexpr87); if (state.failed) return node;

            	    pushFollow(FOLLOW_iffexpr_in_iffexpr93);
            	    iff=iffexpr();

            	    state._fsp--;
            	    if (state.failed) return node;

            	    if ( state.backtracking==0 ) {node = new ASTIffNode(++counter, ifthen, iff);}

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
    // /homes/sdj09/LogicParser.g:38:1: ifexpr returns [ASTNode node] : or= orexpr ( IFTHEN ifthen= ifexpr )* ;
    public final ASTNode ifexpr() throws RecognitionException {
        ASTNode node = null;


        ASTNode or =null;

        ASTNode ifthen =null;


        try {
            // /homes/sdj09/LogicParser.g:39:3: (or= orexpr ( IFTHEN ifthen= ifexpr )* )
            // /homes/sdj09/LogicParser.g:39:5: or= orexpr ( IFTHEN ifthen= ifexpr )*
            {
            pushFollow(FOLLOW_orexpr_in_ifexpr121);
            or=orexpr();

            state._fsp--;
            if (state.failed) return node;

            if ( state.backtracking==0 ) {node = or;}

            // /homes/sdj09/LogicParser.g:39:37: ( IFTHEN ifthen= ifexpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IFTHEN) ) {
                    int LA2_2 = input.LA(2);

                    if ( (synpred2_LogicParser()) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:39:38: IFTHEN ifthen= ifexpr
            	    {
            	    match(input,IFTHEN,FOLLOW_IFTHEN_in_ifexpr126); if (state.failed) return node;

            	    pushFollow(FOLLOW_ifexpr_in_ifexpr132);
            	    ifthen=ifexpr();

            	    state._fsp--;
            	    if (state.failed) return node;

            	    if ( state.backtracking==0 ) {node = new ASTIfThenNode(++counter, or, ifthen);}

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
    // /homes/sdj09/LogicParser.g:42:1: orexpr returns [ASTNode node] : and= andexpr ( OR or= orexpr )* ;
    public final ASTNode orexpr() throws RecognitionException {
        ASTNode node = null;


        ASTNode and =null;

        ASTNode or =null;


        try {
            // /homes/sdj09/LogicParser.g:43:3: (and= andexpr ( OR or= orexpr )* )
            // /homes/sdj09/LogicParser.g:43:5: and= andexpr ( OR or= orexpr )*
            {
            pushFollow(FOLLOW_andexpr_in_orexpr157);
            and=andexpr();

            state._fsp--;
            if (state.failed) return node;

            if ( state.backtracking==0 ) {node = and;}

            // /homes/sdj09/LogicParser.g:43:40: ( OR or= orexpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==OR) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred3_LogicParser()) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:43:41: OR or= orexpr
            	    {
            	    match(input,OR,FOLLOW_OR_in_orexpr162); if (state.failed) return node;

            	    pushFollow(FOLLOW_orexpr_in_orexpr168);
            	    or=orexpr();

            	    state._fsp--;
            	    if (state.failed) return node;

            	    if ( state.backtracking==0 ) {node = new ASTOrNode(++counter, and, or);}

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
    // /homes/sdj09/LogicParser.g:46:1: andexpr returns [ASTNode node] : not= notexpr ( AND and= andexpr )* ;
    public final ASTNode andexpr() throws RecognitionException {
        ASTNode node = null;


        ASTNode not =null;

        ASTNode and =null;


        try {
            // /homes/sdj09/LogicParser.g:47:3: (not= notexpr ( AND and= andexpr )* )
            // /homes/sdj09/LogicParser.g:47:5: not= notexpr ( AND and= andexpr )*
            {
            pushFollow(FOLLOW_notexpr_in_andexpr193);
            not=notexpr();

            state._fsp--;
            if (state.failed) return node;

            if ( state.backtracking==0 ) {node = not;}

            // /homes/sdj09/LogicParser.g:47:40: ( AND and= andexpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==AND) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred4_LogicParser()) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // /homes/sdj09/LogicParser.g:47:41: AND and= andexpr
            	    {
            	    match(input,AND,FOLLOW_AND_in_andexpr198); if (state.failed) return node;

            	    pushFollow(FOLLOW_andexpr_in_andexpr204);
            	    and=andexpr();

            	    state._fsp--;
            	    if (state.failed) return node;

            	    if ( state.backtracking==0 ) {node = new ASTAndNode(++counter, not, and);}

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
    // /homes/sdj09/LogicParser.g:50:1: notexpr returns [ASTNode node] : ( NOT not= notexpr | forallexpr );
    public final ASTNode notexpr() throws RecognitionException {
        ASTNode node = null;


        ASTNode not =null;

        ASTNode forallexpr1 =null;


        try {
            // /homes/sdj09/LogicParser.g:51:3: ( NOT not= notexpr | forallexpr )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NOT) ) {
                alt5=1;
            }
            else if ( ((LA5_0 >= EXISTS && LA5_0 <= ID)||LA5_0==LPAREN||LA5_0==TRUTH) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:51:5: NOT not= notexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notexpr227); if (state.failed) return node;

                    pushFollow(FOLLOW_notexpr_in_notexpr233);
                    not=notexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTNotNode(++counter, not);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:52:5: forallexpr
                    {
                    pushFollow(FOLLOW_forallexpr_in_notexpr241);
                    forallexpr1=forallexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = forallexpr1;}

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



    // $ANTLR start "forallexpr"
    // /homes/sdj09/LogicParser.g:55:1: forallexpr returns [ASTNode node] : ( FORALL ID forall= forallexpr | EXISTS ID exists= forallexpr | identifier );
    public final ASTNode forallexpr() throws RecognitionException {
        ASTNode node = null;


        Token ID2=null;
        Token ID3=null;
        ASTNode forall =null;

        ASTNode exists =null;

        ASTNode identifier4 =null;


        try {
            // /homes/sdj09/LogicParser.g:56:3: ( FORALL ID forall= forallexpr | EXISTS ID exists= forallexpr | identifier )
            int alt6=3;
            switch ( input.LA(1) ) {
            case FORALL:
                {
                alt6=1;
                }
                break;
            case EXISTS:
                {
                alt6=2;
                }
                break;
            case FALSITY:
            case ID:
            case LPAREN:
            case TRUTH:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:56:5: FORALL ID forall= forallexpr
                    {
                    match(input,FORALL,FOLLOW_FORALL_in_forallexpr262); if (state.failed) return node;

                    ID2=(Token)match(input,ID,FOLLOW_ID_in_forallexpr264); if (state.failed) return node;

                    pushFollow(FOLLOW_forallexpr_in_forallexpr270);
                    forall=forallexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTForAllNode(++counter, new ASTIdentifierNode(++counter, (ID2!=null?ID2.getText():null), null, null), forall);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:57:5: EXISTS ID exists= forallexpr
                    {
                    match(input,EXISTS,FOLLOW_EXISTS_in_forallexpr278); if (state.failed) return node;

                    ID3=(Token)match(input,ID,FOLLOW_ID_in_forallexpr280); if (state.failed) return node;

                    pushFollow(FOLLOW_forallexpr_in_forallexpr286);
                    exists=forallexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTExistsNode(++counter, new ASTIdentifierNode(++counter, (ID3!=null?ID3.getText():null), null, null), exists);}

                    }
                    break;
                case 3 :
                    // /homes/sdj09/LogicParser.g:58:5: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_forallexpr294);
                    identifier4=identifier();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = identifier4;}

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
    // $ANTLR end "forallexpr"



    // $ANTLR start "identifier"
    // /homes/sdj09/LogicParser.g:61:1: identifier returns [ASTNode node] : ( ID |relation= ID LPAREN id= ID RPAREN |relation= ID LPAREN id1= ID COMMA id2= ID RPAREN | TRUTH | FALSITY | LPAREN iffexpr RPAREN );
    public final ASTNode identifier() throws RecognitionException {
        ASTNode node = null;


        Token relation=null;
        Token id=null;
        Token id1=null;
        Token id2=null;
        Token ID5=null;
        ASTNode iffexpr6 =null;


        try {
            // /homes/sdj09/LogicParser.g:62:3: ( ID |relation= ID LPAREN id= ID RPAREN |relation= ID LPAREN id1= ID COMMA id2= ID RPAREN | TRUTH | FALSITY | LPAREN iffexpr RPAREN )
            int alt7=6;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==LPAREN) ) {
                    int LA7_5 = input.LA(3);

                    if ( (LA7_5==ID) ) {
                        int LA7_7 = input.LA(4);

                        if ( (LA7_7==RPAREN) ) {
                            alt7=2;
                        }
                        else if ( (LA7_7==COMMA) ) {
                            alt7=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return node;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 7, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return node;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 5, input);

                        throw nvae;

                    }
                }
                else if ( (LA7_1==EOF||LA7_1==AND||(LA7_1 >= IFF && LA7_1 <= IFTHEN)||(LA7_1 >= OR && LA7_1 <= RPAREN)) ) {
                    alt7=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
                }
                break;
            case TRUTH:
                {
                alt7=4;
                }
                break;
            case FALSITY:
                {
                alt7=5;
                }
                break;
            case LPAREN:
                {
                alt7=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:62:5: ID
                    {
                    ID5=(Token)match(input,ID,FOLLOW_ID_in_identifier313); if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTIdentifierNode(++counter, (ID5!=null?ID5.getText():null), null, null);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:63:5: relation= ID LPAREN id= ID RPAREN
                    {
                    relation=(Token)match(input,ID,FOLLOW_ID_in_identifier325); if (state.failed) return node;

                    match(input,LPAREN,FOLLOW_LPAREN_in_identifier327); if (state.failed) return node;

                    id=(Token)match(input,ID,FOLLOW_ID_in_identifier333); if (state.failed) return node;

                    match(input,RPAREN,FOLLOW_RPAREN_in_identifier335); if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTIdentifierNode(++counter, (relation!=null?relation.getText():null), (id!=null?id.getText():null), null);}

                    }
                    break;
                case 3 :
                    // /homes/sdj09/LogicParser.g:64:5: relation= ID LPAREN id1= ID COMMA id2= ID RPAREN
                    {
                    relation=(Token)match(input,ID,FOLLOW_ID_in_identifier347); if (state.failed) return node;

                    match(input,LPAREN,FOLLOW_LPAREN_in_identifier349); if (state.failed) return node;

                    id1=(Token)match(input,ID,FOLLOW_ID_in_identifier355); if (state.failed) return node;

                    match(input,COMMA,FOLLOW_COMMA_in_identifier357); if (state.failed) return node;

                    id2=(Token)match(input,ID,FOLLOW_ID_in_identifier363); if (state.failed) return node;

                    match(input,RPAREN,FOLLOW_RPAREN_in_identifier365); if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTIdentifierNode(++counter, (relation!=null?relation.getText():null), (id1!=null?id1.getText():null), (id2!=null?id2.getText():null));}

                    }
                    break;
                case 4 :
                    // /homes/sdj09/LogicParser.g:65:5: TRUTH
                    {
                    match(input,TRUTH,FOLLOW_TRUTH_in_identifier373); if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTTruthNode(++counter);}

                    }
                    break;
                case 5 :
                    // /homes/sdj09/LogicParser.g:66:5: FALSITY
                    {
                    match(input,FALSITY,FOLLOW_FALSITY_in_identifier381); if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTFalsityNode(++counter);}

                    }
                    break;
                case 6 :
                    // /homes/sdj09/LogicParser.g:67:5: LPAREN iffexpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_identifier389); if (state.failed) return node;

                    pushFollow(FOLLOW_iffexpr_in_identifier391);
                    iffexpr6=iffexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    match(input,RPAREN,FOLLOW_RPAREN_in_identifier393); if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = iffexpr6;}

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

    // $ANTLR start synpred1_LogicParser
    public final void synpred1_LogicParser_fragment() throws RecognitionException {
        ASTNode iff =null;


        // /homes/sdj09/LogicParser.g:35:46: ( IFF iff= iffexpr )
        // /homes/sdj09/LogicParser.g:35:46: IFF iff= iffexpr
        {
        match(input,IFF,FOLLOW_IFF_in_synpred1_LogicParser87); if (state.failed) return ;

        pushFollow(FOLLOW_iffexpr_in_synpred1_LogicParser93);
        iff=iffexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_LogicParser

    // $ANTLR start synpred2_LogicParser
    public final void synpred2_LogicParser_fragment() throws RecognitionException {
        ASTNode ifthen =null;


        // /homes/sdj09/LogicParser.g:39:38: ( IFTHEN ifthen= ifexpr )
        // /homes/sdj09/LogicParser.g:39:38: IFTHEN ifthen= ifexpr
        {
        match(input,IFTHEN,FOLLOW_IFTHEN_in_synpred2_LogicParser126); if (state.failed) return ;

        pushFollow(FOLLOW_ifexpr_in_synpred2_LogicParser132);
        ifthen=ifexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_LogicParser

    // $ANTLR start synpred3_LogicParser
    public final void synpred3_LogicParser_fragment() throws RecognitionException {
        ASTNode or =null;


        // /homes/sdj09/LogicParser.g:43:41: ( OR or= orexpr )
        // /homes/sdj09/LogicParser.g:43:41: OR or= orexpr
        {
        match(input,OR,FOLLOW_OR_in_synpred3_LogicParser162); if (state.failed) return ;

        pushFollow(FOLLOW_orexpr_in_synpred3_LogicParser168);
        or=orexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_LogicParser

    // $ANTLR start synpred4_LogicParser
    public final void synpred4_LogicParser_fragment() throws RecognitionException {
        ASTNode and =null;


        // /homes/sdj09/LogicParser.g:47:41: ( AND and= andexpr )
        // /homes/sdj09/LogicParser.g:47:41: AND and= andexpr
        {
        match(input,AND,FOLLOW_AND_in_synpred4_LogicParser198); if (state.failed) return ;

        pushFollow(FOLLOW_andexpr_in_synpred4_LogicParser204);
        and=andexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_LogicParser

    // Delegated rules

    public final boolean synpred4_LogicParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_LogicParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_LogicParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_LogicParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_LogicParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_LogicParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_LogicParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_LogicParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_iffexpr_in_program57 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifexpr_in_iffexpr82 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IFF_in_iffexpr87 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_iffexpr_in_iffexpr93 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_orexpr_in_ifexpr121 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_IFTHEN_in_ifexpr126 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_ifexpr_in_ifexpr132 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andexpr_in_orexpr157 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_OR_in_orexpr162 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_orexpr_in_orexpr168 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_notexpr_in_andexpr193 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_andexpr198 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_andexpr_in_andexpr204 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_notexpr227 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_notexpr_in_notexpr233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forallexpr_in_notexpr241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORALL_in_forallexpr262 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_forallexpr264 = new BitSet(new long[]{0x00000000000113C0L});
    public static final BitSet FOLLOW_forallexpr_in_forallexpr270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXISTS_in_forallexpr278 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_forallexpr280 = new BitSet(new long[]{0x00000000000113C0L});
    public static final BitSet FOLLOW_forallexpr_in_forallexpr286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_forallexpr294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier325 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_identifier327 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_identifier333 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_identifier335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier347 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_identifier349 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_identifier355 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COMMA_in_identifier357 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_identifier363 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_identifier365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUTH_in_identifier373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSITY_in_identifier381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_identifier389 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_iffexpr_in_identifier391 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_identifier393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFF_in_synpred1_LogicParser87 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_iffexpr_in_synpred1_LogicParser93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFTHEN_in_synpred2_LogicParser126 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_ifexpr_in_synpred2_LogicParser132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_synpred3_LogicParser162 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_orexpr_in_synpred3_LogicParser168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_synpred4_LogicParser198 = new BitSet(new long[]{0x00000000000133C0L});
    public static final BitSet FOLLOW_andexpr_in_synpred4_LogicParser204 = new BitSet(new long[]{0x0000000000000002L});

}
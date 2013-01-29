// $ANTLR 3.4 /homes/sdj09/LogicParser.g 2013-01-29 16:29:19

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
    // /homes/sdj09/LogicParser.g:28:1: program returns [AST tree] : e= iffexpr EOF ;
    public final AST program() throws RecognitionException {
        AST tree = null;


        ASTDoubleConditionalNode e =null;


        try {
            // /homes/sdj09/LogicParser.g:29:3: (e= iffexpr EOF )
            // /homes/sdj09/LogicParser.g:29:5: e= iffexpr EOF
            {
            pushFollow(FOLLOW_iffexpr_in_program57);
            e=iffexpr();

            state._fsp--;
            if (state.failed) return tree;

            if ( state.backtracking==0 ) {tree = new AST(new ASTProgramNode(e));}

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
    // /homes/sdj09/LogicParser.g:32:1: iffexpr returns [ASTDoubleConditionalNode node] : ( ifexpr IFF iff= iffexpr | ifexpr );
    public final ASTDoubleConditionalNode iffexpr() throws RecognitionException {
        ASTDoubleConditionalNode node = null;


        ASTDoubleConditionalNode iff =null;

        ASTConditionalNode ifexpr1 =null;

        ASTConditionalNode ifexpr2 =null;


        try {
            // /homes/sdj09/LogicParser.g:33:3: ( ifexpr IFF iff= iffexpr | ifexpr )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==NOT) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1_LogicParser()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA1_0==ID) ) {
                int LA1_2 = input.LA(2);

                if ( (synpred1_LogicParser()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:33:5: ifexpr IFF iff= iffexpr
                    {
                    pushFollow(FOLLOW_ifexpr_in_iffexpr78);
                    ifexpr1=ifexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    match(input,IFF,FOLLOW_IFF_in_iffexpr80); if (state.failed) return node;

                    pushFollow(FOLLOW_iffexpr_in_iffexpr86);
                    iff=iffexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTIffNode(ifexpr1, iff);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:34:5: ifexpr
                    {
                    pushFollow(FOLLOW_ifexpr_in_iffexpr94);
                    ifexpr2=ifexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = ifexpr2;}

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
    // $ANTLR end "iffexpr"



    // $ANTLR start "ifexpr"
    // /homes/sdj09/LogicParser.g:37:1: ifexpr returns [ASTConditionalNode node] : ( orexpr IFTHEN ifthen= ifexpr | orexpr );
    public final ASTConditionalNode ifexpr() throws RecognitionException {
        ASTConditionalNode node = null;


        ASTConditionalNode ifthen =null;

        ASTDisjunctionNode orexpr3 =null;

        ASTDisjunctionNode orexpr4 =null;


        try {
            // /homes/sdj09/LogicParser.g:38:3: ( orexpr IFTHEN ifthen= ifexpr | orexpr )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NOT) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_LogicParser()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==ID) ) {
                int LA2_2 = input.LA(2);

                if ( (synpred2_LogicParser()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:38:5: orexpr IFTHEN ifthen= ifexpr
                    {
                    pushFollow(FOLLOW_orexpr_in_ifexpr116);
                    orexpr3=orexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    match(input,IFTHEN,FOLLOW_IFTHEN_in_ifexpr118); if (state.failed) return node;

                    pushFollow(FOLLOW_ifexpr_in_ifexpr124);
                    ifthen=ifexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTIfThenNode(orexpr3, ifthen);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:39:5: orexpr
                    {
                    pushFollow(FOLLOW_orexpr_in_ifexpr132);
                    orexpr4=orexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = orexpr4;}

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
    // $ANTLR end "ifexpr"



    // $ANTLR start "orexpr"
    // /homes/sdj09/LogicParser.g:42:1: orexpr returns [ASTDisjunctionNode node] : ( andexpr OR or= orexpr | andexpr );
    public final ASTDisjunctionNode orexpr() throws RecognitionException {
        ASTDisjunctionNode node = null;


        ASTDisjunctionNode or =null;

        ASTConjunctionNode andexpr5 =null;

        ASTConjunctionNode andexpr6 =null;


        try {
            // /homes/sdj09/LogicParser.g:43:3: ( andexpr OR or= orexpr | andexpr )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NOT) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred3_LogicParser()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA3_0==ID) ) {
                int LA3_2 = input.LA(2);

                if ( (synpred3_LogicParser()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:43:5: andexpr OR or= orexpr
                    {
                    pushFollow(FOLLOW_andexpr_in_orexpr151);
                    andexpr5=andexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    match(input,OR,FOLLOW_OR_in_orexpr153); if (state.failed) return node;

                    pushFollow(FOLLOW_orexpr_in_orexpr159);
                    or=orexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTOrNode(andexpr5, or);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:44:5: andexpr
                    {
                    pushFollow(FOLLOW_andexpr_in_orexpr167);
                    andexpr6=andexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = andexpr6;}

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
    // $ANTLR end "orexpr"



    // $ANTLR start "andexpr"
    // /homes/sdj09/LogicParser.g:47:1: andexpr returns [ASTConjunctionNode node] : ( notexpr AND and= andexpr | notexpr );
    public final ASTConjunctionNode andexpr() throws RecognitionException {
        ASTConjunctionNode node = null;


        ASTConjunctionNode and =null;

        ASTUnaryNode notexpr7 =null;

        ASTUnaryNode notexpr8 =null;


        try {
            // /homes/sdj09/LogicParser.g:48:3: ( notexpr AND and= andexpr | notexpr )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NOT) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred4_LogicParser()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA4_0==ID) ) {
                int LA4_2 = input.LA(2);

                if ( (synpred4_LogicParser()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return node;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return node;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /homes/sdj09/LogicParser.g:48:5: notexpr AND and= andexpr
                    {
                    pushFollow(FOLLOW_notexpr_in_andexpr186);
                    notexpr7=notexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    match(input,AND,FOLLOW_AND_in_andexpr188); if (state.failed) return node;

                    pushFollow(FOLLOW_andexpr_in_andexpr194);
                    and=andexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTAndNode(notexpr7, and);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:49:5: notexpr
                    {
                    pushFollow(FOLLOW_notexpr_in_andexpr202);
                    notexpr8=notexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = notexpr8;}

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
    // $ANTLR end "andexpr"



    // $ANTLR start "notexpr"
    // /homes/sdj09/LogicParser.g:51:1: notexpr returns [ASTUnaryNode node] : ( NOT not= notexpr | identifier );
    public final ASTUnaryNode notexpr() throws RecognitionException {
        ASTUnaryNode node = null;


        ASTUnaryNode not =null;

        ASTLiteralNode identifier9 =null;


        try {
            // /homes/sdj09/LogicParser.g:52:3: ( NOT not= notexpr | identifier )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NOT) ) {
                alt5=1;
            }
            else if ( (LA5_0==ID) ) {
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
                    // /homes/sdj09/LogicParser.g:52:5: NOT not= notexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_notexpr220); if (state.failed) return node;

                    pushFollow(FOLLOW_notexpr_in_notexpr226);
                    not=notexpr();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = new ASTNotNode(not);}

                    }
                    break;
                case 2 :
                    // /homes/sdj09/LogicParser.g:53:5: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_notexpr234);
                    identifier9=identifier();

                    state._fsp--;
                    if (state.failed) return node;

                    if ( state.backtracking==0 ) {node = identifier9;}

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
    // /homes/sdj09/LogicParser.g:56:1: identifier returns [ASTLiteralNode node] : ID ;
    public final ASTLiteralNode identifier() throws RecognitionException {
        ASTLiteralNode node = null;


        Token ID10=null;

        try {
            // /homes/sdj09/LogicParser.g:57:3: ( ID )
            // /homes/sdj09/LogicParser.g:57:5: ID
            {
            ID10=(Token)match(input,ID,FOLLOW_ID_in_identifier253); if (state.failed) return node;

            if ( state.backtracking==0 ) {node = new ASTIdentifierNode((ID10!=null?ID10.getText():null));}

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
        ASTDoubleConditionalNode iff =null;


        // /homes/sdj09/LogicParser.g:33:5: ( ifexpr IFF iff= iffexpr )
        // /homes/sdj09/LogicParser.g:33:5: ifexpr IFF iff= iffexpr
        {
        pushFollow(FOLLOW_ifexpr_in_synpred1_LogicParser78);
        ifexpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,IFF,FOLLOW_IFF_in_synpred1_LogicParser80); if (state.failed) return ;

        pushFollow(FOLLOW_iffexpr_in_synpred1_LogicParser86);
        iff=iffexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_LogicParser

    // $ANTLR start synpred2_LogicParser
    public final void synpred2_LogicParser_fragment() throws RecognitionException {
        ASTConditionalNode ifthen =null;


        // /homes/sdj09/LogicParser.g:38:5: ( orexpr IFTHEN ifthen= ifexpr )
        // /homes/sdj09/LogicParser.g:38:5: orexpr IFTHEN ifthen= ifexpr
        {
        pushFollow(FOLLOW_orexpr_in_synpred2_LogicParser116);
        orexpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,IFTHEN,FOLLOW_IFTHEN_in_synpred2_LogicParser118); if (state.failed) return ;

        pushFollow(FOLLOW_ifexpr_in_synpred2_LogicParser124);
        ifthen=ifexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_LogicParser

    // $ANTLR start synpred3_LogicParser
    public final void synpred3_LogicParser_fragment() throws RecognitionException {
        ASTDisjunctionNode or =null;


        // /homes/sdj09/LogicParser.g:43:5: ( andexpr OR or= orexpr )
        // /homes/sdj09/LogicParser.g:43:5: andexpr OR or= orexpr
        {
        pushFollow(FOLLOW_andexpr_in_synpred3_LogicParser151);
        andexpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,OR,FOLLOW_OR_in_synpred3_LogicParser153); if (state.failed) return ;

        pushFollow(FOLLOW_orexpr_in_synpred3_LogicParser159);
        or=orexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_LogicParser

    // $ANTLR start synpred4_LogicParser
    public final void synpred4_LogicParser_fragment() throws RecognitionException {
        ASTConjunctionNode and =null;


        // /homes/sdj09/LogicParser.g:48:5: ( notexpr AND and= andexpr )
        // /homes/sdj09/LogicParser.g:48:5: notexpr AND and= andexpr
        {
        pushFollow(FOLLOW_notexpr_in_synpred4_LogicParser186);
        notexpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,AND,FOLLOW_AND_in_synpred4_LogicParser188); if (state.failed) return ;

        pushFollow(FOLLOW_andexpr_in_synpred4_LogicParser194);
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
    public static final BitSet FOLLOW_ifexpr_in_iffexpr78 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IFF_in_iffexpr80 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_iffexpr_in_iffexpr86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifexpr_in_iffexpr94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orexpr_in_ifexpr116 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IFTHEN_in_ifexpr118 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_ifexpr_in_ifexpr124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orexpr_in_ifexpr132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andexpr_in_orexpr151 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OR_in_orexpr153 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_orexpr_in_orexpr159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andexpr_in_orexpr167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notexpr_in_andexpr186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_AND_in_andexpr188 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_andexpr_in_andexpr194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notexpr_in_andexpr202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notexpr220 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_notexpr_in_notexpr226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_notexpr234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifexpr_in_synpred1_LogicParser78 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IFF_in_synpred1_LogicParser80 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_iffexpr_in_synpred1_LogicParser86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orexpr_in_synpred2_LogicParser116 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IFTHEN_in_synpred2_LogicParser118 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_ifexpr_in_synpred2_LogicParser124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andexpr_in_synpred3_LogicParser151 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OR_in_synpred3_LogicParser153 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_orexpr_in_synpred3_LogicParser159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notexpr_in_synpred4_LogicParser186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_AND_in_synpred4_LogicParser188 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_andexpr_in_synpred4_LogicParser194 = new BitSet(new long[]{0x0000000000000002L});

}
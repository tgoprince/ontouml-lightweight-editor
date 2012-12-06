/* The following code was generated by JFlex 1.4.1 on 06/12/12 20:57 */

/*
 * Generated on 12/6/12 8:57 PM
 */
package br.ufes.inf.nemo.move.ui.ocl;

import java.io.*;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.*;


/**
 * 
 */

public class OCLTokenMaker extends AbstractJFlexTokenMaker {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  @SuppressWarnings("unused")
private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int EOL_COMMENT = 2;
  public static final int YYINITIAL = 0;
  public static final int MLC = 1;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\21\1\10\1\0\1\21\1\17\22\0\1\21\1\40\1\15"+
    "\1\20\1\1\1\40\1\40\1\7\2\41\1\23\1\30\1\40\1\24"+
    "\1\26\1\22\1\4\3\16\4\6\2\3\1\45\1\40\1\17\1\40"+
    "\1\17\1\40\1\20\6\5\24\1\1\41\1\11\1\41\1\17\1\2"+
    "\1\0\1\34\1\14\1\47\1\51\1\27\1\33\1\54\1\42\1\44"+
    "\1\1\1\53\1\35\1\55\1\13\1\50\1\43\1\1\1\32\1\36"+
    "\1\31\1\12\1\52\1\46\1\25\2\1\1\37\1\17\1\37\1\40"+
    "\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\2\1\2\2\1\3\1\4\1\5\1\6\7\1"+
    "\1\7\4\1\1\10\1\11\5\10\1\12\3\10\1\0"+
    "\1\13\1\0\2\13\1\3\1\14\1\0\1\3\2\5"+
    "\1\15\1\16\1\17\1\20\11\1\1\21\11\0\1\20"+
    "\1\0\1\22\1\3\1\23\2\3\1\14\1\3\1\5"+
    "\1\24\1\5\5\1\1\25\3\1\11\0\1\3\1\5"+
    "\1\26\4\1\2\0\1\27\2\0\1\30\1\0\1\3"+
    "\1\5\4\1\5\0\1\3\1\5";

  private static int [] zzUnpackAction() {
    int [] result = new int[125];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0142"+
    "\0\212\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256\0\u0284"+
    "\0\u02b2\0\u02e0\0\212\0\u030e\0\u033c\0\u036a\0\u0398\0\u03c6"+
    "\0\212\0\u03f4\0\u0422\0\u0450\0\u047e\0\u04ac\0\212\0\u04da"+
    "\0\u0508\0\u0536\0\u0564\0\u0592\0\u0228\0\u05c0\0\u05ee\0\u061c"+
    "\0\212\0\u064a\0\u0678\0\u06a6\0\u06d4\0\212\0\212\0\212"+
    "\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844"+
    "\0\u0872\0\u08a0\0\212\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986"+
    "\0\u09b4\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u05ee\0\u0ac8"+
    "\0\212\0\u0af6\0\u0b24\0\u064a\0\u0b52\0\u0b80\0\212\0\u0bae"+
    "\0\u0bdc\0\u0c0a\0\u0c38\0\u0c66\0\u0c94\0\270\0\u0cc2\0\u0cf0"+
    "\0\u0d1e\0\u0d4c\0\u0d7a\0\u0da8\0\u0dd6\0\u0e04\0\u0e32\0\u0e60"+
    "\0\u0e8e\0\u0ebc\0\u0eea\0\u0f18\0\270\0\u0f46\0\u0f74\0\u0fa2"+
    "\0\u0fd0\0\u0ffe\0\u102c\0\u105a\0\u1088\0\u10b6\0\u10e4\0\u1112"+
    "\0\u1140\0\u116e\0\u119c\0\u11ca\0\u11f8\0\u1226\0\u1254\0\u105a"+
    "\0\u1282\0\u10e4\0\u12b0\0\u12de\0\u130c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[125];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\6\1\7\1\5\1\6\1\10\1\11"+
    "\1\4\3\5\1\12\1\6\2\4\1\13\1\14\1\4"+
    "\1\15\1\5\1\16\1\17\1\4\1\20\1\5\1\21"+
    "\2\5\1\22\1\23\1\4\1\23\1\5\1\24\1\25"+
    "\1\4\1\5\1\26\1\5\1\27\4\5\10\30\1\31"+
    "\12\30\1\32\7\30\1\33\6\30\1\34\3\30\1\35"+
    "\7\30\10\36\1\37\22\36\1\40\6\36\1\41\3\36"+
    "\1\42\7\36\57\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\10\5\3\44\2\6\1\44\1\6\2\0"+
    "\4\44\1\0\1\6\1\0\1\44\4\0\1\44\1\45"+
    "\1\46\1\0\6\44\3\0\3\44\1\0\13\44\2\6"+
    "\1\44\1\6\2\0\4\44\1\0\1\6\1\0\1\44"+
    "\4\0\1\47\1\45\1\46\1\0\6\44\3\0\3\44"+
    "\1\0\10\44\7\50\1\51\1\52\1\53\44\50\10\12"+
    "\1\54\1\55\3\12\1\56\40\12\21\0\1\13\57\0"+
    "\1\57\56\0\1\60\34\0\2\61\1\0\1\61\7\0"+
    "\1\61\40\0\6\5\2\0\1\43\1\5\1\62\1\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\1\0\6\5"+
    "\3\0\3\5\1\0\10\5\1\0\6\5\2\0\1\43"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\1\0"+
    "\1\5\1\63\4\5\3\0\3\5\1\0\10\5\1\0"+
    "\6\5\2\0\1\43\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\1\0\3\5\1\64\2\5\3\0\3\5"+
    "\1\0\10\5\1\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\65\1\0\6\5\3\0"+
    "\3\5\1\0\10\5\1\0\6\5\2\0\1\43\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\1\0\3\5"+
    "\1\66\2\5\3\0\3\5\1\0\10\5\1\0\6\5"+
    "\2\0\1\43\1\5\1\67\1\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\1\0\6\5\3\0\3\5\1\0"+
    "\7\5\1\70\1\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\2\5\1\71\5\5\1\0\6\5\2\0"+
    "\1\43\3\5\1\0\1\5\6\0\1\5\1\0\1\72"+
    "\1\0\6\5\3\0\3\5\1\0\10\5\10\30\1\0"+
    "\12\30\1\0\7\30\1\0\6\30\1\0\3\30\1\0"+
    "\7\30\22\0\1\73\64\0\1\74\12\0\1\75\42\0"+
    "\1\76\72\0\1\77\7\0\10\36\1\0\22\36\1\0"+
    "\6\36\1\0\3\36\1\0\7\36\31\0\1\100\12\0"+
    "\1\101\42\0\1\102\72\0\1\103\21\0\1\104\43\0"+
    "\7\44\2\0\4\44\1\0\1\44\1\0\1\44\4\0"+
    "\1\44\1\0\1\44\1\0\6\44\3\0\3\44\1\0"+
    "\13\44\2\105\1\44\1\105\2\0\4\44\1\0\1\105"+
    "\1\0\1\44\3\0\1\106\1\44\1\0\1\44\1\106"+
    "\6\44\3\0\3\44\1\0\13\44\4\107\2\0\3\44"+
    "\1\107\1\0\1\107\1\0\1\44\4\0\1\44\1\0"+
    "\1\107\1\0\2\44\2\107\2\44\3\0\3\44\1\0"+
    "\1\44\1\107\1\44\1\107\4\44\7\110\1\111\1\0"+
    "\45\110\7\0\1\111\46\0\4\110\1\112\1\110\1\113"+
    "\1\114\1\0\1\50\1\115\3\50\1\112\12\110\3\50"+
    "\22\110\11\54\1\116\3\54\1\117\44\54\1\12\1\54"+
    "\2\12\1\0\1\12\1\120\4\12\12\54\3\12\22\54"+
    "\3\44\2\61\1\44\1\61\2\0\4\44\1\0\1\61"+
    "\1\0\1\44\4\0\1\44\1\0\1\46\1\0\6\44"+
    "\3\0\3\44\1\0\10\44\1\0\6\5\2\0\1\43"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\1\0"+
    "\6\5\3\0\3\5\1\0\3\5\1\121\4\5\1\0"+
    "\6\5\2\0\1\43\1\122\2\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\1\0\6\5\3\0\3\5\1\0"+
    "\10\5\1\0\6\5\2\0\1\43\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\1\0\4\5\1\123\1\5"+
    "\3\0\3\5\1\0\10\5\1\0\6\5\2\0\1\43"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\1\0"+
    "\4\5\1\124\1\5\3\0\3\5\1\0\10\5\1\0"+
    "\6\5\2\0\1\43\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\1\0\6\5\3\0\3\5\1\0\1\5"+
    "\1\125\6\5\1\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\4\5\1\126\3\5\1\0\6\5\2\0"+
    "\1\43\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\1\0\6\5\3\0\1\5\1\127\1\5\1\0\10\5"+
    "\1\0\6\5\2\0\1\43\1\5\1\130\1\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\10\5\1\0\6\5\2\0\1\43\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\1\0\1\5"+
    "\1\131\4\5\3\0\3\5\1\0\10\5\43\0\1\132"+
    "\47\0\1\133\51\0\1\134\72\0\1\135\52\0\1\136"+
    "\47\0\1\137\51\0\1\140\72\0\1\141\12\0\4\142"+
    "\5\0\1\142\1\0\1\142\10\0\1\142\3\0\2\142"+
    "\12\0\1\142\1\0\1\142\4\0\3\44\2\105\1\44"+
    "\1\105\2\0\4\44\1\0\1\105\1\0\1\44\4\0"+
    "\1\44\1\0\1\44\1\0\6\44\3\0\3\44\1\0"+
    "\10\44\3\0\2\105\1\0\1\105\7\0\1\105\37\0"+
    "\7\110\1\51\1\0\51\110\1\113\1\110\1\113\1\111"+
    "\1\0\5\110\1\113\43\110\1\50\1\110\1\50\1\111"+
    "\1\0\5\110\1\50\42\110\4\143\1\51\1\0\3\110"+
    "\1\143\1\110\1\143\10\110\1\143\3\110\2\143\12\110"+
    "\1\143\1\110\1\143\4\110\10\54\1\0\50\54\4\144"+
    "\2\54\1\116\2\54\1\144\1\117\1\144\10\54\1\144"+
    "\3\54\2\144\12\54\1\144\1\54\1\144\4\54\1\0"+
    "\6\5\2\0\1\43\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\1\0\6\5\3\0\1\5\1\24\1\5"+
    "\1\0\10\5\1\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\145\1\0\6\5\3\0"+
    "\3\5\1\0\10\5\1\0\6\5\2\0\1\43\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\1\0\5\5"+
    "\1\122\3\0\3\5\1\0\10\5\1\0\6\5\2\0"+
    "\1\43\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\1\0\2\5\1\126\3\5\3\0\3\5\1\0\10\5"+
    "\1\0\6\5\2\0\1\43\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\1\0\6\5\3\0\3\5\1\0"+
    "\5\5\1\146\2\5\1\0\6\5\2\0\1\43\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\1\0\6\5"+
    "\3\0\3\5\1\0\2\5\1\147\5\5\1\0\6\5"+
    "\2\0\1\43\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\1\0\1\150\5\5\3\0\3\5\1\0\10\5"+
    "\1\0\6\5\2\0\1\43\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\1\0\6\5\3\0\2\5\1\151"+
    "\1\0\10\5\45\0\1\152\37\0\1\132\71\0\1\153"+
    "\40\0\1\154\74\0\1\155\37\0\1\136\71\0\1\156"+
    "\40\0\1\157\32\0\4\160\5\0\1\160\1\0\1\160"+
    "\10\0\1\160\3\0\2\160\12\0\1\160\1\0\1\160"+
    "\4\0\3\110\4\161\1\51\1\0\3\110\1\161\1\110"+
    "\1\161\10\110\1\161\3\110\2\161\12\110\1\161\1\110"+
    "\1\161\4\110\3\54\4\162\2\54\1\116\2\54\1\162"+
    "\1\117\1\162\10\54\1\162\3\54\2\162\12\54\1\162"+
    "\1\54\1\162\4\54\1\0\6\5\2\0\1\43\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\1\0\3\5"+
    "\1\163\2\5\3\0\3\5\1\0\10\5\1\0\6\5"+
    "\2\0\1\43\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\1\0\1\5\1\164\4\5\3\0\3\5\1\0"+
    "\10\5\1\0\6\5\2\0\1\43\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\165\1\0\6\5\3\0\3\5"+
    "\1\0\10\5\1\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\4\5\1\166\3\5\22\0\1\167\71\0"+
    "\1\132\6\0\1\152\11\0\1\154\1\170\4\154\1\170"+
    "\2\0\3\154\1\0\1\154\1\0\1\170\1\0\1\154"+
    "\2\170\1\154\1\170\1\154\1\170\6\154\1\0\2\170"+
    "\3\154\1\170\10\154\22\0\1\171\71\0\1\136\6\0"+
    "\1\155\11\0\1\157\1\172\4\157\1\172\2\0\3\157"+
    "\1\0\1\157\1\0\1\172\1\0\1\157\2\172\1\157"+
    "\1\172\1\157\1\172\6\157\1\0\2\172\3\157\1\172"+
    "\10\157\3\0\4\173\5\0\1\173\1\0\1\173\10\0"+
    "\1\173\3\0\2\173\12\0\1\173\1\0\1\173\4\0"+
    "\3\110\4\174\1\51\1\0\3\110\1\174\1\110\1\174"+
    "\10\110\1\174\3\110\2\174\12\110\1\174\1\110\1\174"+
    "\4\110\3\54\4\175\2\54\1\116\2\54\1\175\1\117"+
    "\1\175\10\54\1\175\3\54\2\175\12\54\1\175\1\54"+
    "\1\175\4\54\1\0\6\5\2\0\1\43\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\6\5\1\166\1\5\1\0\6\5\2\0"+
    "\1\43\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\1\0\1\126\5\5\3\0\3\5\1\0\10\5\1\0"+
    "\6\5\2\0\1\43\3\5\1\0\1\5\6\0\1\164"+
    "\1\0\1\5\1\0\6\5\3\0\3\5\1\0\10\5"+
    "\1\0\6\5\2\0\1\43\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\126\1\0\6\5\3\0\3\5\1\0"+
    "\10\5\22\0\1\154\55\0\1\157\36\0\4\5\5\0"+
    "\1\5\1\0\1\5\10\0\1\5\3\0\2\5\12\0"+
    "\1\5\1\0\1\5\4\0\3\110\4\50\1\51\1\0"+
    "\3\110\1\50\1\110\1\50\10\110\1\50\3\110\2\50"+
    "\12\110\1\50\1\110\1\50\4\110\3\54\4\12\2\54"+
    "\1\116\2\54\1\12\1\117\1\12\10\54\1\12\3\54"+
    "\2\12\12\54\1\12\1\54\1\12\4\54";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4922];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\4\1\1\11\11\1\1\11\5\1\1\11"+
    "\5\1\1\11\3\1\1\0\1\1\1\0\3\1\1\11"+
    "\1\0\3\1\3\11\12\1\1\11\11\0\1\1\1\0"+
    "\2\1\1\11\5\1\1\11\12\1\11\0\7\1\2\0"+
    "\1\1\2\0\1\1\1\0\6\1\5\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[125];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  @SuppressWarnings("unused")
private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  @SuppressWarnings("unused")
private int yyline;

  /** the number of characters up to the start of the matched text */
  @SuppressWarnings("unused")
private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  @SuppressWarnings("unused")
private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  @SuppressWarnings("unused")
private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */


	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public OCLTokenMaker() {
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addToken(int, int, int)
	 */
	private void addHyperlinkToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, true);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos-1, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addHyperlinkToken(int, int, int)
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, false);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
	 * @param startOffset The offset in the document at which this token
	 *        occurs.
	 * @param hyperlink Whether this token is a hyperlink.
	 */
	public void addToken(char[] array, int start, int end, int tokenType,
						int startOffset, boolean hyperlink) {
		super.addToken(array, start,end, tokenType, startOffset, hyperlink);
		zzStartRead = zzMarkedPos;
	}


	/**
	 * Returns the text to place at the beginning and end of a
	 * line to "comment" it in a this programming language.
	 *
	 * @return The start and end strings to add to a line to "comment"
	 *         it out.
	 */
	public String[] getLineCommentStartAndEnd() {
		return new String[] { "--", null };
	}


	/**
	 * Returns the first token in the linked list of tokens generated
	 * from <code>text</code>.  This method must be implemented by
	 * subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which
	 *        <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing
	 *         the syntax highlighted text.
	 */
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {

		resetTokenList();
		this.offsetShift = -text.offset + startOffset;

		// Start off in the proper state.
		int state = Token.NULL;
		switch (initialTokenType) {
						case Token.COMMENT_MULTILINE:
				state = MLC;
				start = text.offset;
				break;

			/* No documentation comments */
			default:
				state = Token.NULL;
		}

		s = text;
		try {
			yyreset(zzReader);
			yybegin(state);
			return yylex();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new DefaultToken();
		}

	}


	/**
	 * Refills the input buffer.
	 *
	 * @return      <code>true</code> if EOF was reached, otherwise
	 *              <code>false</code>.
	 */
	private boolean zzRefill() {
		return zzCurrentPos>=s.offset+s.count;
	}


	/**
	 * Resets the scanner to read from a new input stream.
	 * Does not close the old reader.
	 *
	 * All internal variables are reset, the old input stream 
	 * <b>cannot</b> be reused (internal buffer is discarded and lost).
	 * Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader   the new input stream 
	 */
	public final void yyreset(Reader reader) {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill
		 * no longer "refills" the buffer (since the way we do it, it's always
		 * "full" the first time through, since it points to the segment's
		 * array).  So, we assign zzEndRead here.
		 */
		//zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtBOL  = true;
		zzAtEOF  = false;
	}




  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public OCLTokenMaker(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public OCLTokenMaker(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 142) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public org.fife.ui.rsyntaxtextarea.Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { addNullToken(); return firstToken;
          }
        case 25: break;
        case 19: 
          { addToken(Token.LITERAL_CHAR);
          }
        case 26: break;
        case 14: 
          { start = zzMarkedPos-2; yybegin(MLC);
          }
        case 27: break;
        case 6: 
          { addToken(Token.WHITESPACE);
          }
        case 28: break;
        case 18: 
          { addToken(Token.LITERAL_NUMBER_HEXADECIMAL);
          }
        case 29: break;
        case 20: 
          { addToken(Token.ERROR_STRING_DOUBLE);
          }
        case 30: break;
        case 16: 
          { addToken(Token.LITERAL_NUMBER_FLOAT);
          }
        case 31: break;
        case 21: 
          { addToken(Token.RESERVED_WORD);
          }
        case 32: break;
        case 7: 
          { addToken(Token.SEPARATOR);
          }
        case 33: break;
        case 1: 
          { addToken(Token.IDENTIFIER);
          }
        case 34: break;
        case 10: 
          { addToken(start,zzStartRead-1, Token.COMMENT_EOL); addNullToken(); return firstToken;
          }
        case 35: break;
        case 15: 
          { start = zzMarkedPos-2; yybegin(EOL_COMMENT);
          }
        case 36: break;
        case 3: 
          { addToken(Token.ERROR_CHAR); addNullToken(); return firstToken;
          }
        case 37: break;
        case 5: 
          { addToken(Token.ERROR_STRING_DOUBLE); addNullToken(); return firstToken;
          }
        case 38: break;
        case 17: 
          { yybegin(YYINITIAL); addToken(start,zzStartRead+2-1, Token.COMMENT_MULTILINE);
          }
        case 39: break;
        case 12: 
          { addToken(Token.ERROR_CHAR);
          }
        case 40: break;
        case 22: 
          { addToken(Token.LITERAL_BOOLEAN);
          }
        case 41: break;
        case 13: 
          { addToken(Token.LITERAL_STRING_DOUBLE_QUOTE);
          }
        case 42: break;
        case 24: 
          { int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_EOL); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_EOL); start = zzMarkedPos;
          }
        case 43: break;
        case 23: 
          { int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_MULTILINE); start = zzMarkedPos;
          }
        case 44: break;
        case 11: 
          { addToken(Token.ERROR_NUMBER_FORMAT);
          }
        case 45: break;
        case 2: 
          { addToken(Token.LITERAL_NUMBER_DECIMAL_INT);
          }
        case 46: break;
        case 8: 
          { 
          }
        case 47: break;
        case 9: 
          { addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken;
          }
        case 48: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case EOL_COMMENT: {
              addToken(start,zzStartRead-1, Token.COMMENT_EOL); addNullToken(); return firstToken;
            }
            case 126: break;
            case YYINITIAL: {
              addNullToken(); return firstToken;
            }
            case 127: break;
            case MLC: {
              addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken;
            }
            case 128: break;
            default:
            return null;
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

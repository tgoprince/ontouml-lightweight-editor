/* The following code was generated by JFlex 1.4.1 on 06/12/12 21:13 */

/*
 * Generated on 12/6/12 9:13 PM
 */
package br.ufes.inf.nemo.oled.ui.editor.ocl;

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
    "\11\0\1\21\1\10\1\0\1\21\1\17\22\0\1\21\1\32\1\15"+
    "\1\20\1\1\1\32\1\32\1\7\2\33\1\23\1\30\1\32\1\24"+
    "\1\26\1\22\1\4\3\16\4\6\2\3\1\43\1\32\1\17\1\32"+
    "\1\17\1\32\1\20\1\63\1\57\1\60\3\5\2\1\1\61\3\1"+
    "\1\64\1\73\1\62\2\1\1\67\1\66\1\71\1\72\1\65\4\1"+
    "\1\33\1\11\1\33\1\17\1\2\1\0\1\45\1\14\1\52\1\47"+
    "\1\27\1\40\1\55\1\34\1\41\1\1\1\54\1\42\1\56\1\46"+
    "\1\50\1\36\1\70\1\13\1\37\1\35\1\12\1\53\1\44\1\25"+
    "\1\51\1\1\1\31\1\17\1\31\1\32\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\2\1\2\2\1\3\1\4\1\1\1\5\1\6"+
    "\5\1\1\7\23\1\1\10\1\11\5\10\1\12\3\10"+
    "\1\0\1\13\1\0\2\13\1\3\1\14\1\0\1\3"+
    "\1\1\2\5\1\15\1\16\1\17\1\20\12\1\2\21"+
    "\21\1\1\22\11\0\1\20\1\0\1\23\1\3\1\24"+
    "\2\3\1\14\1\3\1\1\1\5\1\25\1\5\5\1"+
    "\1\21\4\1\1\26\12\1\11\0\1\3\1\5\23\1"+
    "\2\0\1\27\2\0\1\30\1\0\1\3\1\5\17\1"+
    "\5\0\1\3\1\5\31\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[223];
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
    "\0\0\0\74\0\170\0\264\0\360\0\u012c\0\u0168\0\u01a4"+
    "\0\264\0\u01e0\0\u021c\0\u0258\0\u0294\0\u02d0\0\u030c\0\u0348"+
    "\0\u0384\0\264\0\u03c0\0\u03fc\0\u0438\0\u0474\0\u04b0\0\u04ec"+
    "\0\u0528\0\u0564\0\u05a0\0\u05dc\0\u0618\0\u0654\0\u0690\0\u06cc"+
    "\0\u0708\0\u0744\0\u0780\0\u07bc\0\u07f8\0\u0834\0\264\0\u0870"+
    "\0\u08ac\0\u08e8\0\u0924\0\u0960\0\264\0\u099c\0\u09d8\0\u0a14"+
    "\0\u0a50\0\u0a8c\0\u0348\0\u0ac8\0\u0b04\0\u0b40\0\264\0\u0b7c"+
    "\0\u0bb8\0\u0bf4\0\u0c30\0\u0c6c\0\264\0\264\0\264\0\u0ca8"+
    "\0\u0ce4\0\u0d20\0\u0d5c\0\u0d98\0\u0dd4\0\u0e10\0\u0e4c\0\u0e88"+
    "\0\u0ec4\0\u0f00\0\360\0\u0f3c\0\u0f78\0\u0fb4\0\u0ff0\0\u102c"+
    "\0\u1068\0\u10a4\0\u10e0\0\u111c\0\u1158\0\u1194\0\u11d0\0\u120c"+
    "\0\u1248\0\u1284\0\u12c0\0\u12fc\0\u1338\0\264\0\u1374\0\u13b0"+
    "\0\u13ec\0\u1428\0\u1464\0\u14a0\0\u14dc\0\u1518\0\u1554\0\u1590"+
    "\0\u15cc\0\u0b04\0\u1608\0\264\0\u1644\0\u1680\0\u0b7c\0\u16bc"+
    "\0\u16f8\0\u1734\0\264\0\u1770\0\u17ac\0\u17e8\0\u1824\0\u1860"+
    "\0\u189c\0\u18d8\0\u1914\0\u1950\0\u198c\0\u19c8\0\360\0\u1a04"+
    "\0\u1a40\0\u1a7c\0\u1ab8\0\u1af4\0\u1b30\0\u1b6c\0\u1ba8\0\u1be4"+
    "\0\u1c20\0\u1c5c\0\u1c98\0\u1cd4\0\u1d10\0\u1d4c\0\u1d88\0\u1dc4"+
    "\0\u1e00\0\u1e3c\0\u1e78\0\u1eb4\0\u1ef0\0\u1f2c\0\u1f68\0\u1fa4"+
    "\0\u1fe0\0\u201c\0\u2058\0\u2094\0\u20d0\0\u210c\0\u2148\0\u2184"+
    "\0\u21c0\0\u21fc\0\u2238\0\u2274\0\u22b0\0\u22ec\0\u2328\0\u2364"+
    "\0\u23a0\0\u23dc\0\u2418\0\u2454\0\u2490\0\u24cc\0\u2508\0\u2544"+
    "\0\u2580\0\u25bc\0\u25f8\0\u2634\0\u2670\0\u26ac\0\u26e8\0\u2724"+
    "\0\u2760\0\u279c\0\u27d8\0\u2814\0\u2850\0\u288c\0\u28c8\0\u2904"+
    "\0\u23dc\0\u2940\0\u2490\0\u297c\0\u29b8\0\u29f4\0\u2a30\0\u2a6c"+
    "\0\u2aa8\0\u2ae4\0\u2b20\0\u2b5c\0\u2b98\0\u2bd4\0\u2c10\0\u2c4c"+
    "\0\u2c88\0\u2cc4\0\u2d00\0\u2d3c\0\u2d78\0\u2db4\0\u2df0\0\u2e2c"+
    "\0\u2e68\0\u2ea4\0\u2ee0\0\u2f1c\0\u2f58\0\u2f94\0\u2fd0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[223];
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
    "\1\4\2\5\1\12\1\13\1\6\2\4\1\14\1\15"+
    "\1\4\1\16\1\17\1\20\1\21\1\4\1\22\1\4"+
    "\1\22\1\5\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\4\1\5\1\31\1\32\1\33\1\34\1\5\1\35"+
    "\4\5\1\36\1\37\1\40\1\41\3\5\1\42\1\43"+
    "\1\5\1\44\1\45\1\5\10\46\1\47\12\46\1\50"+
    "\10\46\1\51\3\46\1\52\3\46\1\53\27\46\10\54"+
    "\1\55\23\54\1\56\3\54\1\57\3\54\1\60\27\54"+
    "\75\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\30\5\3\62"+
    "\2\6\1\62\1\6\2\0\4\62\1\0\1\6\1\0"+
    "\1\62\4\0\1\62\1\63\1\64\4\0\7\62\1\0"+
    "\33\62\2\6\1\62\1\6\2\0\4\62\1\0\1\6"+
    "\1\0\1\62\4\0\1\65\1\63\1\64\4\0\7\62"+
    "\1\0\30\62\7\66\1\67\1\70\1\71\62\66\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\7\5\1\0\4\5\1\72\23\5"+
    "\10\13\1\73\1\74\3\13\1\75\56\13\21\0\1\14"+
    "\75\0\1\76\74\0\1\77\50\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\4\5\1\34\23\5\3\0\2\100\1\0"+
    "\1\100\7\0\1\100\56\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\6\5"+
    "\1\101\1\0\2\5\1\102\25\5\1\0\6\5\2\0"+
    "\1\61\1\5\1\103\1\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\1\104\6\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\1\5\1\105\1\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\7\5\1\0\1\5"+
    "\1\106\2\5\1\107\23\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\110\4\0"+
    "\1\5\1\111\5\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\1\5\1\112\26\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\4\5\1\113\2\5\1\0\2\5\1\114"+
    "\7\5\1\115\15\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\116\4\0\7\5"+
    "\1\0\30\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\2\5\1\117\25\5\1\0\6\5\2\0\1\61\1\120"+
    "\2\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\4\5\1\116\23\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\121"+
    "\4\0\7\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\1\5\1\113\1\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\4\5\1\122\23\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\1\5\1\123\2\5\1\124"+
    "\23\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\7\5\1\0\4\5"+
    "\1\125\23\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\2\5\1\126\25\5\1\0\6\5\2\0\1\61\1\5"+
    "\1\127\1\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\6\5\1\130\21\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\131\4\0\1\5\1\132\5\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\133\4\0\7\5\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\1\134\2\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\7\5\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\2\5\1\135\25\5\10\46"+
    "\1\0\12\46\1\0\10\46\1\0\3\46\1\0\3\46"+
    "\1\0\27\46\22\0\1\136\106\0\1\137\73\0\1\140"+
    "\3\0\1\141\76\0\1\142\27\0\10\54\1\0\23\54"+
    "\1\0\3\54\1\0\3\54\1\0\27\54\35\0\1\143"+
    "\73\0\1\144\3\0\1\145\76\0\1\146\41\0\1\147"+
    "\61\0\7\62\2\0\4\62\1\0\1\62\1\0\1\62"+
    "\4\0\1\62\1\0\1\62\4\0\7\62\1\0\33\62"+
    "\2\150\1\62\1\150\2\0\4\62\1\0\1\150\1\0"+
    "\1\62\3\0\1\151\1\62\1\0\1\62\1\151\3\0"+
    "\7\62\1\0\33\62\4\152\2\0\3\62\1\152\1\0"+
    "\1\152\1\0\1\62\4\0\1\62\1\0\1\152\4\0"+
    "\4\62\1\152\2\62\1\0\1\62\1\152\1\62\1\152"+
    "\2\62\1\152\4\62\2\152\2\62\1\152\10\62\7\153"+
    "\1\154\1\0\63\153\7\0\1\154\64\0\4\153\1\155"+
    "\1\153\1\156\1\157\1\0\1\66\1\160\3\66\1\155"+
    "\16\153\1\66\2\153\1\66\5\153\1\66\25\153\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\7\5\1\0\3\5\1\161\24\5"+
    "\11\73\1\162\3\73\1\163\62\73\1\13\1\73\2\13"+
    "\1\0\1\13\1\164\4\13\16\73\1\13\2\73\1\13"+
    "\5\73\1\13\25\73\3\62\2\100\1\62\1\100\2\0"+
    "\4\62\1\0\1\100\1\0\1\62\4\0\1\62\1\0"+
    "\1\64\4\0\7\62\1\0\30\62\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\3\5\1\105\3\5\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\3\5\1\165\24\5\1\0"+
    "\6\5\2\0\1\61\1\105\2\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\166\4\0\7\5\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\113\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\6\5\1\167\21\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\3\5\1\116\3\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\6\5\1\170\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\7\5\1\0\1\5\1\171\26\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\6\5\1\101\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\5\5\1\116\1\5\1\0"+
    "\7\5\1\172\20\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\2\5"+
    "\1\173\4\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\113\5\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\3\5\1\113\24\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\6\5\1\174\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\1\5\1\175\1\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\4\5\1\113\2\5\1\0"+
    "\30\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\7\5\1\0\2\5"+
    "\1\176\25\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\11\5\1\177\16\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\7\5"+
    "\1\0\4\5\1\200\23\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\6\5\1\201\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\202\5\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\3\5\1\203\24\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\6\5\1\204\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\177\5\5\1\0\24\5\1\205"+
    "\3\5\1\0\6\5\2\0\1\61\1\5\1\206\1\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\7\5"+
    "\1\0\30\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\1\5\1\207\26\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\2\5"+
    "\1\210\4\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\6\5\1\211\1\0\30\5\35\0\1\212\74\0\1\213"+
    "\77\0\1\214\75\0\1\215\64\0\1\216\74\0\1\217"+
    "\77\0\1\220\75\0\1\221\32\0\4\222\5\0\1\222"+
    "\1\0\1\222\10\0\1\222\10\0\1\222\4\0\1\222"+
    "\1\0\1\222\2\0\1\222\4\0\2\222\2\0\1\222"+
    "\10\0\3\62\2\150\1\62\1\150\2\0\4\62\1\0"+
    "\1\150\1\0\1\62\4\0\1\62\1\0\1\62\4\0"+
    "\7\62\1\0\30\62\3\0\2\150\1\0\1\150\7\0"+
    "\1\150\55\0\7\153\1\67\1\0\67\153\1\156\1\153"+
    "\1\156\1\154\1\0\5\153\1\156\61\153\1\66\1\153"+
    "\1\66\1\154\1\0\5\153\1\66\60\153\4\223\1\67"+
    "\1\0\3\153\1\223\1\153\1\223\10\153\1\223\10\153"+
    "\1\223\4\153\1\223\1\153\1\223\2\153\1\223\4\153"+
    "\2\223\2\153\1\223\10\153\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\5\5\1\113\22\5\10\73\1\0\66\73"+
    "\4\224\2\73\1\162\2\73\1\224\1\163\1\224\10\73"+
    "\1\224\10\73\1\224\4\73\1\224\1\73\1\224\2\73"+
    "\1\224\4\73\2\224\2\73\1\224\10\73\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\2\5\1\225\2\5\1\170\1\5\1\0"+
    "\30\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\7\5\1\0\2\5"+
    "\1\113\25\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\10\5\1\226\17\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\4\5"+
    "\1\113\2\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\227\5\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\1\5\1\230\26\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\6\5\1\231\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\6\5\1\113\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\5\5\1\232\1\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\233\5\5\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\6\5\1\234\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\6\5\1\235\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\236\4\0\7\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\237\4\0\7\5\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\15\5\1\240\1\5\1\241"+
    "\1\242\1\243\6\5\1\0\6\5\2\0\1\61\1\244"+
    "\2\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\30\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\5\5"+
    "\1\245\1\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\6\5\1\177\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\6\5\1\246\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\5\5\1\247\1\5\1\0\30\5\36\0\1\250\100\0"+
    "\1\251\57\0\1\213\72\0\1\252\103\0\1\253\100\0"+
    "\1\254\57\0\1\217\72\0\1\255\50\0\4\256\5\0"+
    "\1\256\1\0\1\256\10\0\1\256\10\0\1\256\4\0"+
    "\1\256\1\0\1\256\2\0\1\256\4\0\2\256\2\0"+
    "\1\256\10\0\3\153\4\257\1\67\1\0\3\153\1\257"+
    "\1\153\1\257\10\153\1\257\10\153\1\257\4\153\1\257"+
    "\1\153\1\257\2\153\1\257\4\153\2\257\2\153\1\257"+
    "\10\153\3\73\4\260\2\73\1\162\2\73\1\260\1\163"+
    "\1\260\10\73\1\260\10\73\1\260\4\73\1\260\1\73"+
    "\1\260\2\73\1\260\4\73\2\260\2\73\1\260\10\73"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\1\5\1\106"+
    "\26\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\7\5\1\0\1\5"+
    "\1\261\26\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\5\5\1\262"+
    "\1\5\1\0\30\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\6\5"+
    "\1\263\1\0\30\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\5\5"+
    "\1\264\1\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\7\5\1\105\20\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\265"+
    "\4\0\7\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\266\4\0"+
    "\7\5\1\0\30\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\267\4\0\7\5"+
    "\1\0\30\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\11\5\1\270\16\5\1\0\6\5\2\0\1\61\1\5"+
    "\1\271\1\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\2\5\1\272\25\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\2\5\1\273\25\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\274\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\4\5\1\275\23\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\276\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\2\5\1\123\25\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\177\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\12\5\1\277\15\5\37\0\1\213"+
    "\3\0\1\251\52\0\1\300\52\0\1\252\1\301\4\252"+
    "\1\301\2\0\3\252\1\0\1\252\1\0\1\301\1\0"+
    "\1\252\2\301\1\252\1\301\1\252\1\301\1\0\2\301"+
    "\7\252\1\301\30\252\37\0\1\217\3\0\1\254\52\0"+
    "\1\302\52\0\1\255\1\303\4\255\1\303\2\0\3\255"+
    "\1\0\1\255\1\0\1\303\1\0\1\255\2\303\1\255"+
    "\1\303\1\255\1\303\1\0\2\303\7\255\1\303\30\255"+
    "\3\0\4\304\5\0\1\304\1\0\1\304\10\0\1\304"+
    "\10\0\1\304\4\0\1\304\1\0\1\304\2\0\1\304"+
    "\4\0\2\304\2\0\1\304\10\0\3\153\4\305\1\67"+
    "\1\0\3\153\1\305\1\153\1\305\10\153\1\305\10\153"+
    "\1\305\4\153\1\305\1\153\1\305\2\153\1\305\4\153"+
    "\2\305\2\153\1\305\10\153\3\73\4\306\2\73\1\162"+
    "\2\73\1\306\1\163\1\306\10\73\1\306\10\73\1\306"+
    "\4\73\1\306\1\73\1\306\2\73\1\306\4\73\2\306"+
    "\2\73\1\306\10\73\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\7\5"+
    "\1\0\11\5\1\105\16\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\6\5\1\113\21\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\5\5\1\117\1\5\1\0\30\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\307\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\116\1\0\1\5"+
    "\4\0\7\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\1\5\1\310\26\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\6\5\1\311\21\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\312\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\313"+
    "\4\0\7\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\7\5\1\314\20\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\5\5\1\177\22\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\3\5\1\315\3\5\1\0\30\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\5\5\1\316\1\5\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\2\5\1\317"+
    "\25\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\5\5\1\320\1\5"+
    "\1\0\30\5\22\0\1\252\73\0\1\255\54\0\4\5"+
    "\5\0\1\5\1\0\1\5\10\0\1\5\10\0\1\5"+
    "\4\0\1\5\1\0\1\5\2\0\1\5\4\0\2\5"+
    "\2\0\1\5\10\0\3\153\4\66\1\67\1\0\3\153"+
    "\1\66\1\153\1\66\10\153\1\66\10\153\1\66\4\153"+
    "\1\66\1\153\1\66\2\153\1\66\4\153\2\66\2\153"+
    "\1\66\10\153\3\73\4\13\2\73\1\162\2\73\1\13"+
    "\1\163\1\13\10\73\1\13\10\73\1\13\4\73\1\13"+
    "\1\73\1\13\2\73\1\13\4\73\2\13\2\73\1\13"+
    "\10\73\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\3\5\1\113\3\5"+
    "\1\0\30\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\7\5\1\0"+
    "\2\5\1\177\25\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\321\5\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\1\5\1\177\1\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\3\5\1\322\24\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\1\5\1\323\26\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\3\5\1\324\3\5\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\3\5\1\177"+
    "\24\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\7\5\1\0\6\5"+
    "\1\246\21\5\1\0\6\5\2\0\1\61\3\5\1\0"+
    "\1\5\6\0\1\5\1\0\1\5\4\0\1\5\1\325"+
    "\5\5\1\0\30\5\1\0\6\5\2\0\1\61\3\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\5\5"+
    "\1\326\1\5\1\0\30\5\1\0\6\5\2\0\1\61"+
    "\3\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\22\5\1\327\5\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\6\5\1\275\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\1\5\1\330\26\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\331\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\4\5\1\310\23\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\332\4\0\7\5\1\0\30\5\1\0\6\5\2\0"+
    "\1\61\3\5\1\0\1\5\6\0\1\5\1\0\1\5"+
    "\4\0\7\5\1\0\11\5\1\246\16\5\1\0\6\5"+
    "\2\0\1\61\3\5\1\0\1\5\6\0\1\5\1\0"+
    "\1\5\4\0\7\5\1\0\3\5\1\333\24\5\1\0"+
    "\6\5\2\0\1\61\3\5\1\0\1\5\6\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\177\5\5\1\0\30\5"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\27\5\1\334"+
    "\1\0\6\5\2\0\1\61\3\5\1\0\1\5\6\0"+
    "\1\5\1\0\1\5\4\0\7\5\1\0\1\5\1\335"+
    "\26\5\1\0\6\5\2\0\1\61\3\5\1\0\1\5"+
    "\6\0\1\5\1\0\1\5\4\0\1\5\1\336\5\5"+
    "\1\0\30\5\1\0\6\5\2\0\1\61\1\337\2\5"+
    "\1\0\1\5\6\0\1\5\1\0\1\5\4\0\7\5"+
    "\1\0\30\5\1\0\6\5\2\0\1\61\1\5\1\133"+
    "\1\5\1\0\1\5\6\0\1\5\1\0\1\5\4\0"+
    "\7\5\1\0\30\5";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12300];
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
    "\3\0\1\11\4\1\1\11\10\1\1\11\24\1\1\11"+
    "\5\1\1\11\3\1\1\0\1\1\1\0\3\1\1\11"+
    "\1\0\4\1\3\11\36\1\1\11\11\0\1\1\1\0"+
    "\2\1\1\11\6\1\1\11\26\1\11\0\25\1\2\0"+
    "\1\1\2\0\1\1\1\0\21\1\5\0\33\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[223];
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
			return new Token();
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
    while (i < 174) {
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
        case 20: 
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
        case 19: 
          { addToken(Token.LITERAL_NUMBER_HEXADECIMAL);
          }
        case 29: break;
        case 21: 
          { addToken(Token.ERROR_STRING_DOUBLE);
          }
        case 30: break;
        case 16: 
          { addToken(Token.LITERAL_NUMBER_FLOAT);
          }
        case 31: break;
        case 17: 
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
        case 22: 
          { addToken(Token.DATA_TYPE);
          }
        case 39: break;
        case 18: 
          { yybegin(YYINITIAL); addToken(start,zzStartRead+2-1, Token.COMMENT_MULTILINE);
          }
        case 40: break;
        case 12: 
          { addToken(Token.ERROR_CHAR);
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
            case 224: break;
            case YYINITIAL: {
              addNullToken(); return firstToken;
            }
            case 225: break;
            case MLC: {
              addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE); return firstToken;
            }
            case 226: break;
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

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  public int read(char[] buf, int n) {
      int bufIndex = 0;
      if (bufIndex >= n) {
          return bufIndex;
      }

      char[] buf4 = new char[4];
      int charsRead = read4(buf4);

      while (charsRead > 0) {
          for (int i = 0; i < charsRead; i++) {
              buf[bufIndex++] = buf4[i];

              if (bufIndex >= n) {
                  return bufIndex;
              }
          }

          charsRead = read4(buf4);
      }

      return bufIndex;
  }
}

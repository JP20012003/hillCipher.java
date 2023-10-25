class hillCipher {
/* 3x3 key matrix for 3 characters at once */
public static int[][] keymat = new int[][] { { 1, 2, 1 }, { 2, 3, 2 },
{ 2, 2, 1 } }; /* key inverse matrix */
public static int[][] invkeymat = new int[][] { { -1, 0, 1 }, { 2, -1, 0 }, { -2, 2, -1
} };
public static String key = &quot;ABCDEFGHIJKLMNOPQRSTUVWXYZ&quot;;
private static String encode(char a, char b, char c) {
String ret = &quot;&quot;;
int x, y, z;
int posa = (int) a - 65;
int posb = (int) b - 65;
int posc = (int) c - 65;
x = posa * keymat[0][0] + posb * keymat[1][0] + posc * keymat[2][0];
y = posa * keymat[0][1] + posb * keymat[1][1] + posc * keymat[2][1];
z = posa * keymat[0][2] + posb * keymat[1][2] + posc * keymat[2][2];
a = key.charAt(x % 26);
b = key.charAt(y % 26);

c = key.charAt(z % 26);
ret = &quot;&quot; + a + b + c;
return ret;
}
private static String decode(char a, char b, char c) {
String ret = &quot;&quot;;
int x, y, z;
int posa = (int) a - 65;
int posb = (int) b - 65;
int posc = (int) c - 65;
x = posa * invkeymat[0][0] + posb * invkeymat[1][0] + posc *

invkeymat[2][0];
y = posa * invkeymat[0][1] + posb * invkeymat[1][1] + posc *
invkeymat[2][1];
z = posa * invkeymat[0][2] + posb * invkeymat[1][2] + posc *
invkeymat[2][2];
a = key.charAt((x % 26 &lt; 0) ? (26 + x % 26) : (x % 26));
b = key.charAt((y % 26 &lt; 0) ? (26 + y % 26) : (y % 26));
c = key.charAt((z % 26 &lt; 0) ? (26 + z % 26) : (z % 26));
ret = &quot;&quot; + a + b + c;
return ret;
}
public static void main(String[] args) throws java.lang.Exception {
String msg;
String enc = &quot;&quot;;
String dec = &quot;&quot;;
int n;
msg = (&quot;SecurityLaboratory&quot;);
System.out.println(&quot;simulation of Hill Cipher\n-------------------------&quot;);
System.out.println(&quot;Input message : &quot; + msg);
msg = msg.toUpperCase();
msg = msg.replaceAll(&quot;\\s&quot;, &quot;&quot;);
/* remove spaces */ n = msg.length() % 3;
/* append padding text X */ if (n != 0) {
for (int i = 1; i &lt;= (3 - n); i++) {
msg += &#39;X&#39;;
}

}
System.out.println(&quot;padded message :&quot; + msg);
char[] pdchars = msg.toCharArray();
for (int i = 0; i &lt; msg.length(); i += 3) {

enc += encode(pdchars[i], pdchars[i + 1], pdchars[i + 2]);
}
System.out.println(&quot;encoded message :&quot; + enc);
char[] dechars = enc.toCharArray();
for (int i = 0; i &lt; enc.length(); i += 3) {
dec += decode(dechars[i], dechars[i + 1], dechars[i + 2]);
}
System.out.println(&quot;decoded message :&quot; + dec);
}
}
public class InvertirString
{
    public static void main(String[] args) {        
        /** string original */
        String sD = "Anita lava la tina";
        if (args.length > 0) 
            sD = args[0];
        
        /** string limpio, solo letras o digitos */
        String sL = "";
        for (int i = 0; i < sD.length(); i++) {
            Character c = sD.charAt(i);
            if (Character.isLetterOrDigit(c)) sL += Character.toString(c);
        }
                         
        /** crear un stack vacio */
        Stack<Character> ss = new Stack<Character>();
        
        /** Recorrer el string limpio y llenar el stack */
        for (int i = 0; i < sL.length(); i++)
            ss.push(sL.charAt(i));
        
        /** vaciar el stack y concatenar un nuevo string */
        String sI  = "";
        int tStack = ss.size();
        for (int i = 1; i <= tStack; i++)
            sI += ss.pop();
            
        System.out.println("O: " + sD + "\n");
        System.out.println("L: " + sL);
        System.out.print("---");
        for (int i = 0; i < sD.length(); i++)
            System.out.print("-");
        System.out.println();
        
        System.out.println("I: " + sI);
        
        if (sL.toUpperCase().equals(sI.toUpperCase()))
            System.out.println("\nEl string original es un PALINDROME.");
    }
}

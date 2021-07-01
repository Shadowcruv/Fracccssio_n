/* Write an application program with an Online documentation that can be used by other client programmers
   to accept fractions that can be simplified, be used to compare between themselves for equality and smallest. Also,
   be used to perform arithmetic operations like addition, subtraction, multiplication and division
 */

/**
 * an instance of this class represents a Francccssion.
 *
 * @author Student. Miracle Nnaemeka Ihediwa
 */

public class Francccssion {
    /** The numerator portion of the Fraction(i.e Francccssion class) */
    private int numerator;
    /** The denominator portion of the Fraction(i.e Francccssion class) */
    private int denominator;
    //-----------------------------------------------------------------------
    //Constructors
    //-----------------------------------------------------------------------

    /**
     *Creates a fraction 0/1
     */

    public Francccssion(){
        this(0,1);
    }

    /**
     * Creates a fraction number/1
     *
     * @param number the numerator
     */
    public Francccssion(int number){
        this(number, 1);
    }

    /**
     * Creates a copy of frac
     * @param frac a copy of parameter frac is created
     */
    public Francccssion (Francccssion frac){
        this(frac.getNumerator(),frac.getDenominator());
    }

    /**
     * Creates a fraction num/denom. Expresses negative values interms of -num/denom. If denom is negative
     * and the num is positive,it is converted to a negative num and a positive denom. If denom is negative
     * and num is negative too, then is converts to a positive num and denom. When the num is zero, denom is
     * set to 1. Zero is always represented as 0/1
     *
     * @param num the numerator
     * @param denom the denominator
     */

    public Francccssion(int num, int denom){
        if (denom < 0){
            num = -num;
            denom = -denom;
        }
        if (num==0){
            denom = 1;
        }
        setNumerator(num);
        setDenominator(denom);
    }
    //---------------------------------------------------------------------------------------------------
    // Class Methods
    //
    //----------------------------------------------------------------------------------------------------

    /**
     *Returns the highest/greatest common factor of the parameters m and n.
     *
     * @param m   the first number
     * @param n   the second number
     *
     * @return the highest/greatest common factor
     */
    public static int gcd(int m, int n){
        int r = n % m;
        while (r !=0){
            n = m;
            m = r;
            r = n % m;
        }
        return m;
    }

    /** Returns the smaller fraction between the two fraction parameters f1 and f2.
     *
     * @param f1 the first fraction
     * @param f2 the second fraction
     * @return the smaller fraction between the two fractions
     */
    public static Francccssion min(Francccssion f1, Francccssion f2){
        //converts to decimal and then compare
        double f1_dec = f1.decimal();
        double f2_dec = f2.decimal();

        if(f1_dec <= f2_dec){
            return f1;
        } else{
            return f2;
        }
    }
    //---------------------------------------------------------------------------------
    // Public Instance Methods
    //----------------------------------------------------------------------------------

    /**
     * Returns the sum of this fraction and parameter frac. The sum returned is not simplified.
     *
     * @param frac the fraction to be added to this Fraction
     * @return the sum of this fraction and parameter frac.
     */
    public Francccssion add (Francccssion frac){
        int a, b,c,d;

        Francccssion sum;
        a = this.getNumerator();
        b = this.getDenominator();
        c = this.getNumerator();
        d = frac.getDenominator();

        sum = new Francccssion(a*d + b*c, b*d);
        return sum;
    }

    /**
     * Returns the sum between this fraction and  parameter number. The sum is not simplified
     *
     * @param number the integer to add to this fraction
     * @return the sum between this fraction and parameter number.
     */
    public Francccssion add (int number){
        Francccssion frac = new Francccssion( number,1);

        Francccssion sum = add(frac);
        return sum;
    }

    /**
     * Returns the quotient of this Fraction divided by parameter frac. The quotient returned is not simplified.
     *
     * @param frac the fraction to the divide this fraction
     * @return the quotient of this Fraction divided by parameter frac.
     */

    public Francccssion divide(Francccssion frac){
        int a, b, c, d;
        Francccssion quotient;
        a = this.getNumerator();
        b = this.getDenominator();
        c = frac.getNumerator();
        d = frac.getDenominator();

        quotient = new Francccssion (a*d,b*c);
        return quotient;
    }

    /**
     * Returns the quotient of this Fraction divided by parameter number
     * @param number the number to divide this Fraction
     * @return the quotient of this Fraction divided by parameter number
     */

    public Francccssion divide ( int number){
        Francccssion frac = new Francccssion(number, 1);
        Francccssion quotient = divide(frac);
        return quotient;
    }

    /**
     * Compares this Fraction and parameter frac for equality. The fractions are individually simplified
     * first before tested for equality.
     *
     * @param frac the fraction object to compare
     * @return true if they are equal
     */
    public boolean equals(Francccssion frac){
       //simplify the two fractions
        Francccssion f1 = simplify();
        Francccssion f2 = frac.simplify();

        return (f1. getNumerator() == f2.getNumerator() && f2.getNumerator()==f2.getDenominator());
    }

    /**
     * Returns the denominator of this fraction
     *
     * @return the denominator of this fraction
     */
    public int getDenominator(){
        return denominator;
    }

    /**
     * Returns the numerator of this fraction
     *
     * @return the numerator of this fraction
     */

    public int getNumerator(){
        return numerator;
    }

    /**
     * Returns the product of this Fraction and parameter frac. The product is not simplified.
     *
     * @param frac the fraction to multiply this Fraction
     * @return the product of this Fraction and  frac
     */
    public Francccssion multiply(Francccssion frac){
        int a, b,c,d;
        Francccssion product;
        a = this.getNumerator();
        b = this.getDenominator();
        c = this.getNumerator();
        d = this.getDenominator();

        product = new Francccssion(a*c, b*d);
        return product;
    }

    /**
     * Returns the product of this Fraction and int parameter number. The product is not simplified.
     *
     * @param number the number to multiply this Fraction
     * @return the product of this Fraction and int parameter number
     */
    public Francccssion multiply ( int number){
        Francccssion frac = new Francccssion(number,1);
        Francccssion product = multiply(frac);
        return  product;
    }

    /**
     * Sets denominator of this fraction to parameter denom. Gives an error if parameter denom is 0
     *
     * @param denom the denominator of this fraction
     */
    public void setDenominator(int denom){
        if(denom==0){
            //Fatal error
            System.out.println("Fatal Error");
            System.exit(1);
        }
        denominator = denom;
    }

    /**
     * Sets numerator of this fraction to int parameter num
     *
     * @param num the numerator of this fraction
     */
    public void setNumerator(int num){
        numerator = num;
    }

    /**
     * Returns a new Fraction object that is the simplest form of the fraction
     *
     * @return the simplest form of the fraction
     */
    public Francccssion simplify(){
        int num = getNumerator();
        int denom = getDenominator();
        int divisor = 1;
        if (num!=0){
            divisor = gcd(Math.abs(num), denom);
        }
        return new Francccssion(num/divisor, denom/divisor);
    }

    /**
     * Returns the difference of this Fraction and parameter frac. The difference is not simplified.
     *
     * @param frac the fraction to be subtracted from this Fraction.
     * @return the difference of this Fraction and parameter frac
     */

    public Francccssion subtract (Francccssion frac){
        int a,b,c,d;
        Francccssion diff;
        a = this.getNumerator();
        b = this.getDenominator();
        c = this.getNumerator();
        d = this.getDenominator();

        diff = new Francccssion(a*b - b*c, b*d);
        return diff;

    }

    /**
     * Returns the difference of this Fraction and int parameter number. The difference
     * is not simplified.
     *
     * @param number is the number to be subtracted from this Fraction
     * @return the difference of this Fraction and int parameter number.
     */
      public Francccssion subtract(int number){
        Francccssion frac = new Francccssion(number, 1);
        Francccssion difference = subtract(frac);
        return difference;
      }

    /**
     * Returns the String representation of this Fraction
     *
     * @return the String representation of this Fraction.
     */
      public String toString(){
        return getNumerator() + "/" + getDenominator();

      }

    /**
     * Returns the decimal equivalent of this Fraction
     *
     * @return  the decimal equivalent of this Fraction
     */
    //-----------------------------------------------------------------------------------
    // Private Instant Methods
    //-----------------------------------------------------------------------------------

      private double decimal(){
      //returns the decimal equivalent
          return (double) getNumerator() / getDenominator();
    }
}

package BasicJava.lession_3_5;

import java.util.Arrays;

/**
 * AsciiCharSequence class implements a compact storage of a sequence
 * of ASCII characters (codes fit in one byte) into a byte array.
 * Created by btow on 28.10.2016.
 */
public class AsciiCharSequence implements CharSequence {

    /** The value is used for character storage. */
    private final byte value[];

    /** Cache the hash code for the string */
    private int hash; // Default to 0

    /**
     * Initializes a newly created {@code String} object so that it represents
     * an empty character sequence.  Note that use of this constructor is
     * unnecessary since Strings are immutable.
     */
    public AsciiCharSequence() {
        this.value = new String("").getBytes();
    }

    /**
     * Allocates a new {@code String} so that it represents the sequence of
     * characters currently contained in the byte array argument. The
     * contents of the byte array are copied; subsequent modification of
     * the byte array does not affect the newly created string.
     *
     * @param  value
     *         The initial value of the string
     */
    public AsciiCharSequence(byte value[]) {
        this.value = value;
        this.hash = hashCode();
    }

    /**
     * Allocates a new {@code AsciiCharSequence} that contains characters from a subarray
     * of the byte array argument. The {@code offset} argument is the
     * index of the first character of the subarray and the {@code count}
     * argument specifies the length of the subarray. The contents of the
     * subarray are copied; subsequent modification of the byte array does
     * not affect the newly created string.
     *
     * @param  value
     *         Array that is the source of characters
     *
     * @param  offset
     *         The initial offset
     *
     * @param  count
     *         The length
     *
     * @throws  IndexOutOfBoundsException
     *          If the {@code offset} and {@code count} arguments index
     *          characters outside the bounds of the {@code value} array
     */
    public AsciiCharSequence(byte value[], int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count <= 0) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(count);
            }
            if (offset <= value.length) {
                this.value = "".getBytes();
                return;
            }
        }
        // Note: offset or count might be near -1>>>1.
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset+count);
    }

    /**
     * Returns the length of this string.
     * The length is equal to the number of <a href="Character.html#unicode">Unicode
     * code units</a> in the string.
     *
     * @return  the length of the sequence of characters represented by this
     *          object.
     */
    @Override
    public int length() {
        return value.length;
    }

    /**
     * Returns the {@code char} value at the
     * specified index. An index ranges from {@code 0} to
     * {@code length() - 1}. The first {@code char} value of the sequence
     * is at index {@code 0}, the next at index {@code 1},
     * and so on, as for array indexing.
     *
     * <p>If the {@code char} value specified by the index is a
     * <a href="Character.html#unicode">surrogate</a>, the surrogate
     * value is returned.
     *
     * @param      index   the index of the {@code char} value.
     * @return     the {@code char} value at the specified index of this string.
     *             The first {@code char} value is at index {@code 0}.
     * @exception  IndexOutOfBoundsException  if the {@code index}
     *             argument is negative or not less than the length of this
     *             string.
     */
    @Override
    public char charAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return (char)value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > value.length) {
            throw new StringIndexOutOfBoundsException(end);
        }
        int subLen = end - start;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return ((start == 0) && (end == value.length)) ? this
                : new AsciiCharSequence(value, start, subLen);
    }

    @Override
    public String toString() {

        return new String(this.value);

    }

}

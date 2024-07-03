package util;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static util.Colors.*;

public class InputMethods {
    private static final String ERROR_ALERT =  RED + "===>> Định dạng không hợp lệ, hoặc ngoài phạm vi! Vui lòng thử lại..." +RESET;
    private static final String EMPTY_ALERT = RED + "===>>* Trường nhập vào không thể để trống! Vui lòng nhập lại..." + RESET;
    private static final String DATE_FORMAT = RED + "===>> Định dạng ngày tháng không hợp lệ (dd/MM/yyyy)! Vui lòng thử lại..." + RESET;
    /*=======================Bắt đầu phương thức nhập liệu============================*/

    /*
     * getString() Trả về giá trị Chuỗi từ người dùng.
     */

    public static String getString() {
        while (true) {
            String result = getInput();
            if (result.trim().isEmpty()) {
                System.out.println(EMPTY_ALERT);
            }else {

            return result;
            }
        }
    }

    /*
     * getChar() Trả về giá trị Ký tự từ người dùng.
     */

    public static char getChar() {
        return getString().charAt(0);
    }

    /*
     * getBoolean() Trả về giá trị Boolean từ người dùng.
     */
    public static boolean getBoolean() {
        String result = getString();
        return result.equalsIgnoreCase("true");
    }

    /**
     * getByte()  Trả về giá trị Byte từ người dùng.
     */
    public static byte getByte() {
        while (true) {
            try {
                return Byte.parseByte(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getShort()  Trả về giá trị Short từ người dùng.
     */

    public static short getShort() {
        while (true) {
            try {
                return Short.parseShort(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getInteger() Trả về giá trị Integer từ người dùng.
     */
    public static int getInteger() {
        while (true) {
            try {
                return Integer.parseInt(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    public static int getIntegerStock(){
        while (true) {
            try {
                int input = Integer.parseInt(getString());
                if (input > 0) {
                    return input;
                } else {
                    System.err.println(RED + "Số nhập vào phải lớn hơn 0." + RESET);
                }
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getLong()  Trả về giá trị Long từ người dùng.
     */
    public static long getLong() {
        while (true) {
            try {
                return Long.parseLong(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getFloat()  Trả về giá trị Float từ người dùng.
     */
    public static float getFloat() {
        while (true) {
            try {
                return Float.parseFloat(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getDouble()  Trả về giá trị Double từ người dùng.
     */
    public static double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    public static double getDoublePrice() {
        while (true) {
            try {
                double input = Double.parseDouble(getString());
                if (input > 0) {
                    return input;
                } else {
                    System.err.println("Số nhập vào phải lớn hơn 0.");
                }
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /*=================Phương thức nhập kết thúc======================*/



    /*
     * getInput() Trả về bất kỳ giá trị Chuỗi nào từ người dùng.
     */
    private static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * pressAnyKey()  Bấm phím bất kỳ để tiếp tục....
     */
    public static void pressAnyKey() {
        getInput();
    }
    /*===================Phương pháp khác===================*/
    public static long getPositiveLong() {
        while (true) {
            long result = getLong();
            if (result < 0) {
                System.err.println(RED + "Vui lòng nhập số dương" + RESET);
                continue;
            }
            return result;
        }
    }

    public static double getPresent() {
        while (true) {
            double result = getDouble();
            if (result < 0 || result > 10) {
                System.err.println(RED + "Nhập sai rồi từ 1 đến 10" + RESET);
                continue;
            }
            return result;
        }
    }

    public static int getMonth() {
        while (true) {
            int month = getInteger();
            if (month < 0 || month > 12) {
                System.err.println(RED + "Nhập sai tháng, Nhập lại từ 1 đến 12: " + RESET);
                continue;
            }
            return month;
        }
    }

    public static int getDay() {
        while (true) {
            int month = getInteger();
            if (month < 0 || month > 31) {
                System.err.println( RED + "Nhập sai tháng, Nhập lại từ 1 đến 31: " + RESET);
                continue;
            }
            return month;
        }
    }

    public static Date getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                return sdf.parse(getInput());
            }
            catch (NumberFormatException errException) {
                System.err.println(DATE_FORMAT);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static DecimalFormat formatNumber() {
        return new DecimalFormat("###,###,###");
    }
}

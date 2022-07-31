package tracker.utils;


import tracker.constants.Constants;

public class DelimiterInputDataStudent {

    public String[] get(String inputString) {
        String[] result = new String[3];
        String[] data = inputString.split(" ");
        if (inputString.equals(Constants.COMMAND_BACK)) {
            return data;
        }

        if (data.length < 3) {
            return null;
        }

        result[0] = data[0];
        result[2] = data[data.length - 1];
        for (int i = 1; i < data.length - 1; i++) {
            if (result[1] == null) {
                result[1] = data[i];
            } else {
                result[1] += " " + data[i];
            }
        }

        return result;


    }
}

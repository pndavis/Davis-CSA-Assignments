package mystery;

/**
 *  __  __               _             __  __           _                  
 * |  \/  |             | |           |  \/  |         | |                 
 * | \  / |_   _ _ __ __| | ___ _ __  | \  / |_   _ ___| |_ ___ _ __ _   _ 
 * | |\/| | | | | '__/ _` |/ _ \ '__| | |\/| | | | / __| __/ _ \ '__| | | |
 * | |  | | |_| | | | (_| |  __/ |    | |  | | |_| \__ \ ||  __/ |  | |_| |
 * |_|  |_|\__,_|_|  \__,_|\___|_|    |_|  |_|\__, |___/\__\___|_|   \__, |
 *                                            __/ |                  __/ |
 * 𝔸 𝕕𝕖𝕓𝕦𝕘𝕘𝕖𝕣-𝕓𝕒𝕤𝕖𝕕 𝕄𝕪𝕤𝕥𝕖𝕣𝕪 𝕊𝕠𝕝𝕧𝕚𝕟𝕘 𝕘𝕒𝕞𝕖   |___/                  |___/ 
 *                                        
 * This is a driver class for the murder mystery game
 *
 * See the assignment description for information on running and debugging
 *     
 * @author Colin Sullivan
 * @author Steven Chen
 * 
 */
public class MurderMystery {

    private static Mansion mysteryMansion;
    // Number of game related questions to ask, 9 max 
    public static final int randomQuestions = 3;
    // Number of code line questions to ask, 7 max
    public static final int fileQuestions = 2;

    /**
     * NOTE: It is REQUIRED that you run your program with YOUR loginID via the terminal. 
     * You will receive a 0 if you do not submit with your correct loginID.
     */
    public static void main(String[] args) {

        MurderMystery.clearScreen();
        System.out.println("Please enter your loginID:");
        String loginID = StdIn.readString();
        StdIn.readLine();

        // loginID CHECk
        if (!MurderMystery.validloginID(loginID)) {
            return;
        }

        boolean continueGame = true;
        System.out.println("Print Intro? (Y/N)");
        boolean intro = StdIn.readLine().toLowerCase().contains("y");
        mysteryMansion = new Mansion(loginID, !intro); // Create mansion
        while (continueGame) {
            continueGame = mysteryMansion.nextTurn();
        }

        MurderMystery.clearScreen();
        MurderMystery.printOutput(loginID, mysteryMansion.endGame());
    
    }

    /***
     * This method can be used to limit loginID types.
     * It accepts all login IDs by default.
     * 
     * @param id
     * @return
     */
    private static boolean validloginID(String id) { 
        return true;
    }

    //////////////////////////// HELPER METHODS ///////////////////////////////////////////////////////////////////////////////////////////////

    /***
     * Prints text for one turn
     * 
     * @param int time Time past 0, 5 mins per turn
     * 
     * @param int player Number of players
     */
    public static void printTurn(int time, int players) {
        MurderMystery.clearScreen();

        // Calculate time in 12H format and print
        int hours = time / 60;
        int minutes = time % 60;
        System.out.print("It is currently " + (6 + hours) + ":");
        if (minutes < 10) {
            System.out.println("0" + minutes + "pm");
        } else {
            System.out.println(minutes + "pm");
        }

        System.out.println(players + " players remain.\n");

        // Ask user for number of turns to run
        System.out.println("How many turns would you like to simulate? (1 turn = 5 minutes)");
        System.out.println("\n\n\n\n\n");
    }

    /**
     * Takes a loginID and turns it into a value which can be used
     * to seed StdRandom
     * 
     * @param loginID a valid loginID
     * 
     * @return an long value seed
     */
    public static long hash(String input) {// If no loginID was read, or loginID is incorrect length
        if (!MurderMystery.validloginID(input)) {
            return 1;
        }
        String seed = "";
        for (int i = 0; i < input.length(); i++) { // Concatenates the ascii value of each loginID char to an string
            int ascii = (int) input.charAt(i);
            seed = seed + String.valueOf(ascii);
        }
        if (seed.length() > 18) {
            seed = seed.substring(0, seed.length() - 18);
        }
        long seedVal = Long.parseLong(seed); // Parses string to long and returns
        return seedVal;
    }

    /**
     * Sleep method
     * 
     * @param int milliseconds to sleep
     */
    public static void wait(int milli) {
        try {
            Thread.sleep(milli);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Clears terminal
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Intro text generator. Reads from "Intro.in" file.
     */
    public static void printIntro(Person[] players) {
        StdIn.setFile("res/Intro.in"); // Read from intro text file

        MurderMystery.clearScreen();

        int lines = Integer.parseInt(StdIn.readLine()); // Number of lines for first paragraph
        for (int line = 0; line < lines; line++) { // Read and print lines adding pauses in between
            System.out.println(StdIn.readLine());
            int wait = Integer.parseInt(StdIn.readLine());
            MurderMystery.wait(wait);
        }

        MurderMystery.clearScreen();

        int linesInCloud = StdIn.readInt();
        int linesInLightning = StdIn.readInt();
        StdIn.readLine();

        for (int line = 0; line < linesInCloud; line++) { // Print cloud (all at once)
            System.out.println(StdIn.readLine());
        }

        for (int line = 0; line < linesInLightning; line++) { // Animate lightning by printing with pauses

            if (line == 0) {
                MurderMystery.wait(800);
            } else if (line < linesInLightning - 1) {
                MurderMystery.wait(30);
            } else {
                MurderMystery.wait(100); // After done fully printing, wait longer
            }

            System.out.println(StdIn.readLine());
        }

        int titleScreenLines = StdIn.readInt();
        while (titleScreenLines >= 0) { // Print Murder Mystery title screen
            System.out.println(StdIn.readLine());
            titleScreenLines--;
        }

        MurderMystery.wait(3500);
        MurderMystery.clearScreen();
        int introText = StdIn.readInt();
        StdIn.readChar();
        for (int line = 0; line < introText; line++) {
            System.out.println(StdIn.readLine() + "\n");
            MurderMystery.wait(2500);
        }
        MurderMystery.wait(1500);
        for (int p = 0; p < players.length; p++) {
            if (p % 2 != 0 || p == 1) {
                System.out.println("\t\t" + players[p].getName());
                MurderMystery.wait(1200);
            } else {
                System.out.println(players[p].getName());
                MurderMystery.wait(1200);
            }
        }
        StdIn.resetFile();
    }

    /**
     * Prints end game message with end time, # murdered.
     */
    public static void endGameStats() {

        System.out.println(" _____                     _____                ");
        System.out.println("|   __| ___  _____  ___   |     | _ _  ___  ___ ");
        System.out.println("|  |  || . ||     || -_|  |  |  || | || -_||  _|");
        System.out.println("|_____||__1||_|_|_||___|  |_____| \\_/ |___||_| \n");
        MurderMystery.wait(3000);

        int hrs = mysteryMansion.time() / 60;
        int mins = mysteryMansion.time() % 60;
        System.out.print("The game ended at " + (mysteryMansion.getStartAndEndTimes()[0] + hrs) + ":");
        if (mins < 10) {
            System.out.println("0" + mins + "pm");
        } else {
            System.out.println(mins + "pm");
        }
        MurderMystery.wait(2000);

        // 5 Players + A murderer
        if (((mysteryMansion.getPlayers().length - 1) - mysteryMansion.alivePlayers()) > 0) {
            System.out.println(mysteryMansion.getPlayers().length - mysteryMansion.alivePlayers()
                    + " players were murdered. The murderer was caught.");
        } else {
            System.out.println(mysteryMansion.getPlayers().length - mysteryMansion.alivePlayers()
                    + " players were murdered. The murderer got away.");
        }
        MurderMystery.wait(3500);

        MurderMystery.clearScreen();
    }

    /**
     * Generate and ask questions through the terminal
     */
    public static String[] askQuestions() {
        // Read in non random questions
        StdIn.setFile("res/Questions.in");
        int setQuestionCount = Integer.parseInt(StdIn.readLine());
        String[] setQuestionPool = new String[setQuestionCount];
        for (int line = 0; line < setQuestionCount; line++) {
            setQuestionPool[line] = StdIn.readLine();
        }

        String[][] unparsed = mysteryMansion.getRandomQuestions(randomQuestions);
        String[] randomQuestionPool = MurderMystery.parseQuestions(unparsed, mysteryMansion);
        String[] codeQuestionPool = mysteryMansion.getFileQuestions(fileQuestions);

        // Ask questions and record answers
        int totalQuestions = randomQuestions + fileQuestions + setQuestionCount;
        String[] questions = new String[totalQuestions];
        for (int question = 0; question < totalQuestions;) {
            if (question < setQuestionCount) {
                questions[question] = setQuestionPool[question];
            } else if (question < setQuestionCount + randomQuestions) {
                questions[question] = randomQuestionPool[question - setQuestionCount];
            } else {
                questions[question] = codeQuestionPool[question - setQuestionCount - randomQuestions];
            }
            question++;
        }

        // Reset StdIn to the terminal
        StdIn.resetFile();
        String[] answers = new String[questions.length];
        // Ask questions and record answers
        int i = 0;
        for (String question : questions) {
            System.out.println("Question " + (i + 1) + " / " + questions.length);
            System.out.println(question);
            answers[i++] = StdIn.readLine();
            MurderMystery.clearScreen();
        }
        return answers;
    }

    /**
     * Reads a String[][] of tokens and parses the possible combinations
     * into their output strings
     * 
     * Each row is 3 Strings representing the possible random questions
     * The possible tokens are:
     * TIME,PLAYER,DEATH,ROOM,DROP,GRAB
     * The possible combinations (questionss) are:
     * TIME,PLAYER,DEATH - What time did PLAYER die?
     * ROOM,PLAYER,DEATH - What room did PLAYER die?
     * ROOM,ITEM,DROP - What room did ITEM get dropped first?
     * ROOM,ITEM,GRAB - What room did ITEM get picked up last?
     * TIME,ITEM,DROP - What time did ITEM get dropped last?
     * TIME,ITEM,GRAB - What time did ITEM get picked up first?
     * ROOM,PLAYER,TIME - What room was PLAYER in at TIME?
     * PLAYER,TIME,GRAB - How many players were dead at TIME?
     * PLAYER,TIME,DROP - How many players were alive at TIME?
     * Random variables above like PLAYER, ITEM, and TIME are replaced by a possible
     * in game answer
     */
    public static String[] parseQuestions(String[][] questions, Mansion mystery) {
        String[] parsed = new String[questions.length];
        int j = 0;
        for (int i = 0; i < questions.length; i++) {
            String que = "";
            if (questions[i][0].equals("TIME") && questions[i][2].equals("DEATH")) {
                que += "At what time did ";
                que += questions[i][1];
                que += " die? (Give your answer in XX:XXpm form, write \"Alive\" if they never died)";
            } else if (questions[i][0].equals("TIME") && questions[i][2].equals("DROP")) {
                que += "When did ";
                que += questions[i][1];
                que += " get dropped last? (Give your answer in XX:XXpm form, write \"Untouched\" if it was never dropped)";
            } else if (questions[i][0].equals("TIME") && questions[i][2].equals("GRAB")) {
                que += "What time did ";
                que += questions[i][1];
                que += " get picked up first? (Give your answer in XX:XXpm form, write \"Untouched\" if it was never grabbed)";
            } else if (questions[i][0].equals("ROOM") && questions[i][2].equals("DEATH")) {
                que += "In what room did ";
                que += questions[i][1];
                que += " die (Write \"Alive\" if they never died)?";
            } else if (questions[i][0].equals("ROOM") && questions[i][2].equals("DROP")) {
                que += "What room did ";
                que += questions[i][1];
                que += " get dropped first? (Write \"Untouched\" if it was never dropped)";
            } else if (questions[i][0].equals("ROOM") && questions[i][2].equals("GRAB")) {
                que += "Where did ";
                que += questions[i][1];
                que += " get picked up last? (Write \"Untouched\" if it was never grabbed)";
            } else if (questions[i][0].equals("PLAYER") && questions[i][2].equals("GRAB")) {
                que += "How many players were dead at ";
                int hour = mystery.getStartAndEndTimes()[0] + Integer.parseInt(questions[i][1]) / 60;
                que += hour + ":";
                int minute = Integer.parseInt(questions[i][1]) % 60;
                if (minute < 10) {
                    que += "0" + minute + "pm?";
                } else {
                    que += minute + "pm?";
                }  
            } else if (questions[i][0].equals("PLAYER") && questions[i][2].equals("DROP")) {
                que += "How many players were alive at ";
                int hour = mystery.getStartAndEndTimes()[0] + Integer.parseInt(questions[i][1]) / 60;
                que += hour + ":";
                int minute = Integer.parseInt(questions[i][1]) % 60;
                if (minute < 10) {
                    que += "0" + minute + "pm?";
                } else {
                    que += minute + "pm?";
                }
            } else if (questions[i][0].equals("ROOM")) {
                que += "What room was ";
                que += questions[i][1];
                int hour = mystery.getStartAndEndTimes()[0] + Integer.parseInt(questions[i][2]) / 60;
                que += " in at " + hour + ":";
                int minute = Integer.parseInt(questions[i][2]) % 60;
                if (minute < 10) {
                    que += "0" + minute + "pm?";
                } else {
                    que += minute + "pm?";
                }
            }

            parsed[j++] = que;
        }
        return parsed;
    }

    public static void printOutput(String loginID, String[] ans) {
        StdOut.setFile("Answers.out");
        StdOut.print(loginID + "\n");
        for (int i = 0; i < ans.length; i++) {
            StdOut.print(ans[i] + "\n");
        }
    }
}

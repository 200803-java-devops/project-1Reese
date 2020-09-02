package project1.reesebenson.Parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project1.reesebenson.ProcessUtils.Pair;

public class GitParserTest {

    @Test
    public void CurrentBranchParseTest(){
        String actual = GitOutputParser.PraseCurrentBranchFromGitBranch("blah\n new\n*master\n");
        assertEquals("master", actual);

        actual = GitOutputParser.PraseCurrentBranchFromGitBranch("*blah\nnew\nmaster\n");
        assertEquals("blah", actual);
    }

    @Test
    public void RemoteBranchParse(){
        //looks for origin and uses that if present
        String actual = GitOutputParser.PasreRemoteFromGitRemoteShow("new\nmaster\norigin\n");
        assertEquals("origin", actual);
        //if no origin use first line
        actual = GitOutputParser.PasreRemoteFromGitRemoteShow("new\nother\nremote\n");
        assertEquals("new", actual);
    }

    @Test
    public void ParsePushResultsForResponseTest(){
        String toParse = "fatal: error, error\n fatal:mop";
        String failed = "push failed with response:\n";
        String remote = "origin";
        String branch = "new";
        String success = "Push successful\n";
        String newBranch = "New branch " + branch + " Added to remote:" + remote + "\n";
        Pair<Boolean, String> actual = GitOutputParser.ParsePushResultsForResponse(toParse, remote , branch);
        Pair<Boolean, String> expected = new Pair<> (false, failed + toParse);
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());

        toParse = "error: an error occured\n you had an error oh no!";
        actual = GitOutputParser.ParsePushResultsForResponse(toParse, remote , branch);
        expected = new Pair<> (false, failed + toParse);
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());

        toParse = "this was sucessful";
        actual = GitOutputParser.ParsePushResultsForResponse(toParse, remote , branch);
        expected = new Pair<> (true, success);
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());

        toParse = "this was suceessful [new branch] new-> new";
        actual = GitOutputParser.ParsePushResultsForResponse(toParse, remote , branch);
        expected = new Pair<> (true, success + newBranch);
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());
    }
    
}

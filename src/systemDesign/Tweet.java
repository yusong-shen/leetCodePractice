import java.util.UUID;

public class Tweet {

	public UUID uuid;
	public int id;
	public int user_id;
	public String text;
	
	public Tweet(int user_id, String tweet_text) {
		this.user_id = user_id;
		this.text = tweet_text;
	}
	
	public static Tweet create(int user_id, String tweet_text) {
		// This will create a new tweet object,
		// and auto fill id
		Tweet tweet = new Tweet(user_id, tweet_text);
		tweet.uuid = UUID.randomUUID();
		tweet.id = (int) Math.random()*Integer.MAX_VALUE;
		return tweet;
		
	}

}

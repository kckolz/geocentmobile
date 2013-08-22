package kolz.android.rss;

import java.util.List;

import kolz.android.domain.Message;


public interface FeedParser {
    List<Message> parse();
}

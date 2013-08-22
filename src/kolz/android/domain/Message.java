package kolz.android.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Message implements Comparable<Message>{
	
    static SimpleDateFormat FORMATTER = 
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
    private String title;
    private URL link;
	private String description;
    private Date date;
    private String author;
    
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public URL getLink() {
		return link;
	}

    public void setLink(String link) {
        try {
            this.link = new URL(link);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDate() {
        return FORMATTER.format(this.date);
    }

    public void setDate(String date) {
        // pad the date if necessary
        while (!date.endsWith("00")){
            date += "0";
        }
        try {
            this.date = FORMATTER.parse(date.trim());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getTitle());
    	sb.append(this.getDate());
    	return sb.toString();
    }

    @Override
    public int hashCode() {
		int hash = 1;
		hash = hash * 31 + getTitle().hashCode();
		hash = hash * 31 + (getDate() == null ? 0 : getDate().hashCode());
		return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
        	return true;
        }
        if(!(obj instanceof Message)) {
        	return false;
        }
        Message otherMessage = (Message) obj;
        return 
          (title.equals(otherMessage.getTitle()))
            && ((date == null) 
                ? otherMessage.getDate() == null 
                : date.equals(otherMessage.getDate()));
    }
      // sort by date
    public int compareTo(Message another) {
        if (another == null) return 1;
        // sort descending, most recent first
        return another.date.compareTo(date);
    }
    
    public Message copy() {
    	try {
			return (Message)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	return null;
    }
}

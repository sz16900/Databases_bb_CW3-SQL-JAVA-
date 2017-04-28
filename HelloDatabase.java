import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class HelloDatabase implements Runnable {
static final String CONNECTION =
"jdbc:mariadb://localhost:3306/census" +
"?user=student&localSocket=";
Connection c;
final String socket;
public HelloDatabase(String socket) {
this.socket = socket;
}
public void open() {
try {
// Set up the database connection.
c = DriverManager.getConnection(CONNECTION + socket);
} catch (SQLException e) {
c = null;
throw new RuntimeException(e);
}
}
public void close() {
try {
if (c == null) { return; }
c.close();
c = null;
} catch (SQLException e) {
throw new RuntimeException(e);
}
}
public List<String> getOccupations() {
if (c == null) { throw new IllegalStateException(); }
List<String> list = new LinkedList<>();
try {
PreparedStatement s = c.prepareStatement(
"SELECT id, name from Occupation");
ResultSet r = s.executeQuery();
while (r.next()) {
list.add(r.getString("name") +
" (" + r.getInt("id") + ")");
}
r.close();
return list;
} catch (SQLException e) {
throw new RuntimeException(e);
}
}
@Override public void run() {
open();
try {
List<String> occupations = getOccupations();
for (String s : occupations) {
System.out.println(s);
}
} finally {
close();
}
}
public static void main(String[] args) {
if (args.length < 1) {
System.err.println("Use: HelloDatabase <socket>");
return;
}
HelloDatabase h = new HelloDatabase(args[0]);
h.run();
}
}

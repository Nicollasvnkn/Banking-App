package org.example.Junior_Exercises.Exercise12;

import org.example.Junior_Exercises.Exercise10.BankAccount;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountRepository {
    private final File file;

    public AccountRepository(String path) {
        this.file = new File(path);
    }

    public void save(List<BankAccount> accounts) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {

            out.println("\"Account Number\",\"Account Name\",\"Account Balance\",\"Created Date\",\"Last Update\"");

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);

            for (int i = 0; i < accounts.size(); i++) {
                BankAccount a = accounts.get(i);
                int number = i + 1;

                String created = "";
                String updated = "";
                try {
                    var createdAt = a.getCreatedAt();
                    var updatedAt = a.getCreatedAt();
                    if (createdAt != null) created = createdAt.format(fmt);
                    if (updatedAt != null) created = updatedAt.format(fmt);
                } catch (NoSuchMethodError | Exception ignore) {

                }
                out.println(String.join(",",
                        csv(String.valueOf(number)),
                        csv(a.getOwner()),
                        csv(String.format(Locale.US, "%.2f", a.getBalance())),
                        csv(created),
                        csv(updated)
                ));
            }
        }
    }

    private static String csv(String s){
        if (s == null) return "\"\"";
        return "\"" + s.replace("\"","\"\"") + "\"";
    }

    public List<BankAccount> load() throws IOException{
        List<BankAccount> list = new ArrayList<>();
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;
            boolean first = true;
            while ((line = br.readLine())!= null) {
                if(first) {
                    first = false;
                    continue;
                }
                String[] parts = line.split("(?<!\\\\),");
                if (parts.length < 3) continue;

                String owner = parts[1].replace("\\,",",");
                double balance = Double.parseDouble(parts[2]);
                list.add(new BankAccount(owner, balance));
            }
        }
        return list;
    }
}

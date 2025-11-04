package org.example.Junior_Exercises.Exercise13;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.Junior_Exercises.Exercise10.BankAccount;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JsonAccountRepository {
    private final File file;
    private final Gson gson;

    public JsonAccountRepository (String path) {
        this.file = new File(path);
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }

    public void save(List<BankAccount> accounts) throws IOException {
        try (Writer w = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
        gson.toJson(accounts, w);
        }
    }

    public List<BankAccount> load() throws IOException {
        if(!file.exists()) {
            return new java.util.ArrayList<>();
        }
        try (Reader r = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)){
            Type listType = new TypeToken<List<BankAccount>>() {}.getType();
            return gson.fromJson(r, listType);
        }
    }

    static class LocalDateTimeAdapter
            implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
        private static final DateTimeFormatter FMT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        @Override
        public JsonElement serialize(LocalDateTime src, Type t, JsonSerializationContext c){
            return new JsonPrimitive(src.format(FMT));
    }

        @Override
        public LocalDateTime deserialize(JsonElement json, Type t, JsonDeserializationContext c)
            throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), FMT);
        }
    }
}

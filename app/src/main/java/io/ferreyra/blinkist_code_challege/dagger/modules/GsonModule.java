package io.ferreyra.blinkist_code_challege.dagger.modules;

/**
 * Created by carlos on 10/28/17.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;

import dagger.Module;
import dagger.Provides;
import io.ferreyra.blinkist_code_challege.dagger.AppScope;
import io.ferreyra.blinkist_code_challege.persistance.utils.DateTimeSerializer;

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson providesGson (DateTimeSerializer dateTimeSerializer){
        return new GsonBuilder()
                .registerTypeAdapter(DateTime.class , dateTimeSerializer)
                .create();

    }

    @AppScope
    @Provides
    public DateTimeSerializer provideDateTimeSerializer() {
        return new DateTimeSerializer();
    }
}

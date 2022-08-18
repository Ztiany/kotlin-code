package retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class ErrorJsonLenientConverterFactory extends Converter.Factory {

    private final Converter.Factory mGsonConverterFactory;

    public ErrorJsonLenientConverterFactory(Converter.Factory gsonConverterFactory) {
        mGsonConverterFactory = gsonConverterFactory;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return mGsonConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        final Converter<ResponseBody, ?> delegateConverter = mGsonConverterFactory.responseBodyConverter(type, annotations, retrofit);
        assert delegateConverter != null;

        return (Converter<ResponseBody, Object>) value -> {
            try {
                return delegateConverter.convert(value);
            } catch (Exception e/*防止闪退：JsonSyntaxException、IOException or MalformedJsonException*/) {
                System.out.println("Json covert error -->error ");
                return null;
            }
        };

    }

}
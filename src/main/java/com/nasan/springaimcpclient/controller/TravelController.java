package com.nasan.springaimcpclient.controller;

import com.nasan.springaimcpclient.model.TravelResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RestController
@RequestMapping("/api/travel")
public class TravelController {
    
    private final ChatClient chatClient;

    public TravelController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/search")
    public ResponseEntity<TravelResponse> searchTravel(
            @RequestParam String city,
            @RequestParam(required = false) String destinationCity,
            @RequestParam String date,
            @RequestParam(defaultValue = "5") int maxFlights,
            @RequestParam(defaultValue = "5") int maxHotels,
            @RequestParam(defaultValue = "economy") String flightClass,
            @RequestParam(defaultValue = "3") int minHotelStars) {

        // Şehir adı validation
        if (city == null || city.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        // Tarih format validation (YYYY-MM-DD)
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            // Structured output için BeanOutputConverter
            var outputConverter = new BeanOutputConverter<>(TravelResponse.class);

            String systemPrompt = String.format(
                "Sen bir seyahat asistanısın. MCP tool'larını kullanarak uçuş ve otel arama yapacaksın.\n" +
                "Görevin:\n" +
                "1. %s şehrinden %s şehrine %s tarihinde gidecek en iyi %d uçuşu bul\n" +
                "2. %s şehrinde %d yıldız ve üzeri en iyi %d oteli bul\n" +
                "3. Uçuş sınıfı: %s\n" +
                "4. Fiyatları USD cinsinden göster\n" +
                "5. Sonuçları detaylı ve doğru şekilde formatla\n" +
                "\n%s",
                    destinationCity,city, date, maxFlights, city, minHotelStars, maxHotels, flightClass,
                outputConverter.getFormat()
            );

            String userPrompt = String.format(
                "%s şehrinden %s şehrine %s tarihinde seyahat planlıyorum. " +
                "En uygun uçuş ve otel seçeneklerini bul ve karşılaştır. " +
                "Tercihim: %s sınıfı uçuş, en az %d yıldızlı otel.",
                    destinationCity, city, date, flightClass, minHotelStars
            );

            TravelResponse travelResponse = chatClient.prompt()
                    .system(systemPrompt)
                    .user(userPrompt)
                    .call()
                    .entity(TravelResponse.class);

            return ResponseEntity.ok(travelResponse);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getTravelStatus() {
        return ResponseEntity.ok(Map.of(
                "service", "Travel Search Service",
                "version", "1.0",
                "mcpIntegrated", true,
                "structuredOutput", true,
                "supportedCities", "Global",
                "supportedFlightClasses", new String[]{"economy", "business", "first"},
                "hotelStarRange", "1-5",
                "currency", "USD",
                "endpoints", Map.of(
                        "basicSearch", "/api/travel/search",
                        "advancedSearch", "/api/travel/search (POST)",
                        "status", "/api/travel/status"
                ),
                "mcpTools", Map.of(
                        "flightSearch", "Searches available flights",
                        "hotelSearch", "Searches available hotels",
                        "priceComparison", "Compares prices across providers"
                )
        ));
    }

    @GetMapping("/cities")
    public ResponseEntity<Map<String, Object>> getSupportedCities() {
        return ResponseEntity.ok(Map.of(
                "popularDestinations", new String[]{
                        "Istanbul", "London", "Paris", "New York", "Tokyo", 
                        "Dubai", "Singapore", "Amsterdam", "Berlin", "Rome"
                },
                "searchTip", "Şehir adını İngilizce veya Türkçe yazabilirsiniz",
                "dateFormat", "YYYY-MM-DD (örnek: 2024-12-25)",
                "timeZone", "UTC",
                "bookingNote", "Bu servis sadece arama yapar, rezervasyon yapmaz"
        ));
    }
}

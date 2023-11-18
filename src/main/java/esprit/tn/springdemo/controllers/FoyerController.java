package esprit.tn.springdemo.controllers;

import esprit.tn.springdemo.entities.Foyer;
import esprit.tn.springdemo.responses.ApiResponse;
import esprit.tn.springdemo.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyers")
public class FoyerController {
    private final IFoyerService foyerService;

    @GetMapping("")
    public ResponseEntity<ApiResponse> getAllFoyers() {
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<Foyer> foyers = foyerService.retrieveAllFoyers();
            apiResponse.setResponse(HttpStatus.OK, "Foyers retrieved successfully.");
            apiResponse.addData("foyers", foyers);
        } catch (Exception e) {
            apiResponse.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(apiResponse, apiResponse._getHttpStatus());
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> addFoyer(@RequestBody Foyer f) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Foyer addedFoyer = foyerService.addFoyer(f);
            apiResponse.setResponse(HttpStatus.CREATED, "Foyer added successfully.");
            apiResponse.addData("foyer", addedFoyer);
        } catch (Exception e) {
            apiResponse.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(apiResponse, apiResponse._getHttpStatus());
    }

    @PutMapping("/{idFoyer}")
    public ResponseEntity<ApiResponse> updateFoyer(@RequestBody Foyer f, @PathVariable long idFoyer) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Foyer foundFoyer = foyerService.retrieveFoyer(idFoyer);
            if (foundFoyer == null) {
                apiResponse.setResponse(HttpStatus.NOT_FOUND, "Foyer not found.");
            } else {
                f.setId(idFoyer);
                Foyer updatedFoyer = foyerService.updateFoyer(f);
                apiResponse.setResponse(HttpStatus.OK, "Foyer updated successfully.");
                apiResponse.addData("foyer", updatedFoyer);
            }
        } catch (Exception e) {
            apiResponse.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(apiResponse, apiResponse._getHttpStatus());
    }

    @DeleteMapping("/{idFoyer}")
    public ResponseEntity<ApiResponse> deleteFoyer(@PathVariable long idFoyer) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Foyer foundFoyer = foyerService.retrieveFoyer(idFoyer);
            if (foundFoyer == null) {
                apiResponse.setResponse(HttpStatus.NOT_FOUND, "Foyer not found.");
            } else {
                foyerService.removeFoyer(idFoyer);
                apiResponse.setResponse(HttpStatus.OK, "Foyer deleted successfully.");
            }
        } catch (Exception e) {
            apiResponse.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(apiResponse, apiResponse._getHttpStatus());
    }

    @GetMapping("/{idFoyer}")
    public ResponseEntity<ApiResponse> getFoyer(@PathVariable long idFoyer) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Foyer foundFoyer = foyerService.retrieveFoyer(idFoyer);
            if (foundFoyer == null) {
                apiResponse.setResponse(HttpStatus.NOT_FOUND, "Foyer not found.");
            } else {
                apiResponse.setResponse(HttpStatus.OK, "Foyer retrieved successfully.");
                apiResponse.addData("foyer", foundFoyer);
            }
        } catch (Exception e) {
            apiResponse.setResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(apiResponse, apiResponse._getHttpStatus());
    }
}

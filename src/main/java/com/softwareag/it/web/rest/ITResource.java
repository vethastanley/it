package com.softwareag.it.web.rest;

import com.softwareag.it.domain.App;
import com.softwareag.it.domain.Request;
import com.softwareag.it.domain.enumeration.Status;
import com.softwareag.it.repository.RequestRepository;
import com.softwareag.it.service.RequestService;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/it")
@Transactional
public class ITResource {

    private final Logger log = LoggerFactory.getLogger(ITResource.class);

    private final RequestService requestService;

    private final RequestRepository requestRepository;
    private final AppResource appResource;

    public ITResource(RequestService requestService, RequestRepository requestRepository, AppResource appResource) {
        this.requestService = requestService;
        this.requestRepository = requestRepository;
        this.appResource = appResource;
    }

    @PostMapping("/request")
    public ResponseEntity<Request> onBoardApplications(@RequestBody Request request) throws URISyntaxException {
        log.debug("REST request to save new Request : {}", request);
        Request result = requestService.save(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{requestId}/status/{status}")
    public ResponseEntity<Boolean> updateStatusOfRequest(
        @PathVariable(value = "requestId", required = false) final UUID requestId,
        @PathVariable(value = "status", required = false) final String status
    ) {
        log.debug("REST request to save new Request : {}", requestId);
        Request result = requestService.findOne(requestId).get();
        result.setStatus(Status.valueOf(status));
        return ResponseEntity.ok(true);
    }

    @PostMapping("/{requestId}/onboard")
    public ResponseEntity<RequestLite> createRequest(
        @PathVariable(value = "requestId", required = false) final UUID requestId,
        @RequestBody RequestLite request
    ) throws URISyntaxException {
        log.debug("REST create request for creating applications{}", requestId);
        Request result = requestService.findOne(requestId).get();
        RequestLite requestLite = new RequestLite();
        requestLite.setApplicationID(request.getApplicationID());

        Set<App> list = new HashSet<>();
        for (App app : request.getApps()) {
            app.setRequest(result);
            App aftersave = appResource.createApp(app).getBody();
            list.add(aftersave);
        }
        requestLite.setApps(list);

        return ResponseEntity.ok(requestLite);
    }
}

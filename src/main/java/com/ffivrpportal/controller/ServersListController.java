package com.ffivrpportal.controller;

import com.ffivrpportal.service.ServersListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servers")
public class ServersListController {

    ServersListService serversListService;
}

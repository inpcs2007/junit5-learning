/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package cn.inpcs.learningjunit5.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type Message component.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-10 14:52:52
 */
@Component
public class MessageComponent {

    @Autowired
    private MessageService messageService;

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return messageService.getMessage();
    }
}
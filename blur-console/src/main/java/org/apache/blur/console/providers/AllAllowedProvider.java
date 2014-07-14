package org.apache.blur.console.providers;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.blur.BlurConfiguration;
import org.apache.blur.console.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class AllAllowedProvider extends BaseProvider {
  private static class AllAllowedUser extends User {

    private String password;

    public AllAllowedUser() {
      this.name = "User";
      this.roles = Arrays.asList(ADMIN_ROLE);
    }

    private boolean checkPassword(String passwd) {
      return password.equals(passwd);
    }
  }
  @Override
  public User login(HttpServletRequest request) {
    return new AllAllowedUser();
  }
}

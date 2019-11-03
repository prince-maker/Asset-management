package com.example.assetManagement.model;

public class JwtResponse {
	
	 private String token;
	    private String type = "Bearer";
	    private Long userId;
	    
	 
	    public JwtResponse(String accessToken,Long userId) {
	        this.token = accessToken;
	        this.userId=userId;
	    }
	 
	    public String getAccessToken() {
	        return token;
	    }
	 
	    public void setAccessToken(String accessToken) {
	        this.token = accessToken;
	    }
	 
	    public String getTokenType() {
	        return type;
	    }
	 
	    public void setTokenType(String tokenType) {
	        this.type = tokenType;
	    }

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}
	    
	    

}

/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.extras.fido.metadata;

import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.text.ParseException;

/**
 * Test for CertPathJWSVerifier
 */
public class CertPathJWSVerifierTest {

    private CertPathJWSVerifier target;

    @Before
    public void setup() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        target = new CertPathJWSVerifier(resourceLoader);
    }

    @Test
    public void test() throws ParseException {
        String token = "eyJhbGciOiAiRVMyNTYiLCAidHlwIjogIkpXVCIsICJ4NWMiOiBbIk1JSUNuVENDQWtPZ0F3SUJBZ0lPUnZDTTFhdVU2RllWWFVlYkpIY3dDZ1lJS29aSXpqMEVBd0l3VXpFTE1Ba0dBMVVFQmhNQ1ZWTXhGakFVQmdOVkJBb1REVVpKUkU4Z1FXeHNhV0Z1WTJVeEhUQWJCZ05WQkFzVEZFMWxkR0ZrWVhSaElGUlBReUJUYVdkdWFXNW5NUTB3Q3dZRFZRUURFd1JEUVMweE1CNFhEVEUxTURneE9UQXdNREF3TUZvWERURTRNRGd4T1RBd01EQXdNRm93WkRFTE1Ba0dBMVVFQmhNQ1ZWTXhGakFVQmdOVkJBb1REVVpKUkU4Z1FXeHNhV0Z1WTJVeEhUQWJCZ05WQkFzVEZFMWxkR0ZrWVhSaElGUlBReUJUYVdkdWFXNW5NUjR3SEFZRFZRUURFeFZOWlhSaFpHRjBZU0JVVDBNZ1UybG5ibVZ5SURNd1dUQVRCZ2NxaGtqT1BRSUJCZ2dxaGtqT1BRTUJCd05DQUFTS1grcDNXMmoxR1Y0bFF3bjdIWE5qNGxoOWUyd0FhNko5dEJJUWhiUVRrcU12TlpHbkh4T243eVRaM05wWU81WkdWZ3IvWEM2NnFsaTdCV0E4amdUZm80SHBNSUhtTUE0R0ExVWREd0VCL3dRRUF3SUd3REFNQmdOVkhSTUJBZjhFQWpBQU1CMEdBMVVkRGdRV0JCUmNrTkYrenp4TXVMdm0rcVJqTGVKUWYwRHd5ekFmQmdOVkhTTUVHREFXZ0JScEVWNHRhV1NGblphNDF2OWN6Yjg4ZGM5TUdEQTFCZ05WSFI4RUxqQXNNQ3FnS0tBbWhpUm9kSFJ3T2k4dmJXUnpMbVpwWkc5aGJHeHBZVzVqWlM1dmNtY3ZRMEV0TVM1amNtd3dUd1lEVlIwZ0JFZ3dSakJFQmdzckJnRUVBWUxsSEFFREFUQTFNRE1HQ0NzR0FRVUZCd0lCRmlkb2RIUndjem92TDIxa2N5NW1hV1J2WVd4c2FXRnVZMlV1YjNKbkwzSmxjRzl6YVhSdmNua3dDZ1lJS29aSXpqMEVBd0lEU0FBd1JRSWhBTExiWWpCcmJoUGt3cm4zbVFqQ0VSSXdrTU5OVC9sZmtwTlhIKzR6alVYRUFpQmFzMmxQNmpwNDRCaDRYK3RCWHFZN3k2MWlqR1JJWkNhQUYxS0lsZ3ViMGc9PSIsICJNSUlDc2pDQ0FqaWdBd0lCQWdJT1JxbXhrOE5RdUpmQ0VOVllhMVF3Q2dZSUtvWkl6ajBFQXdNd1V6RUxNQWtHQTFVRUJoTUNWVk14RmpBVUJnTlZCQW9URFVaSlJFOGdRV3hzYVdGdVkyVXhIVEFiQmdOVkJBc1RGRTFsZEdGa1lYUmhJRlJQUXlCVGFXZHVhVzVuTVEwd0N3WURWUVFERXdSU2IyOTBNQjRYRFRFMU1EWXhOekF3TURBd01Gb1hEVFF3TURZeE56QXdNREF3TUZvd1V6RUxNQWtHQTFVRUJoTUNWVk14RmpBVUJnTlZCQW9URFVaSlJFOGdRV3hzYVdGdVkyVXhIVEFiQmdOVkJBc1RGRTFsZEdGa1lYUmhJRlJQUXlCVGFXZHVhVzVuTVEwd0N3WURWUVFERXdSRFFTMHhNRmt3RXdZSEtvWkl6ajBDQVFZSUtvWkl6ajBEQVFjRFFnQUU5c0RnQzhQekJZbC93S3FwWGZhOThqT0lvNzhsOXB6NHhPekdER0l6MHpFWE1Yc0JZNmtBaHlVNEdSbVQwd280dHlVdng1Qlk4T0tsc0xNemxiS01SYU9CN3pDQjdEQU9CZ05WSFE4QkFmOEVCQU1DQVFZd0VnWURWUjBUQVFIL0JBZ3dCZ0VCL3dJQkFEQWRCZ05WSFE0RUZnUVVhUkZlTFdsa2haMld1TmIvWE0yL1BIWFBUQmd3SHdZRFZSMGpCQmd3Rm9BVTBxVWZDNmYyWXNoQTFOaTl1ZGVPMFZTN3ZFWXdOUVlEVlIwZkJDNHdMREFxb0NpZ0pvWWthSFIwY0RvdkwyMWtjeTVtYVdSdllXeHNhV0Z1WTJVdWIzSm5MMUp2YjNRdVkzSnNNRThHQTFVZElBUklNRVl3UkFZTEt3WUJCQUdDNVJ3QkF3RXdOVEF6QmdnckJnRUZCUWNDQVJZbmFIUjBjSE02THk5dFpITXVabWxrYjJGc2JHbGhibU5sTG05eVp5OXlaWEJ2YzJsMGIzSjVNQW9HQ0NxR1NNNDlCQU1EQTJnQU1HVUNNQkxWcTBKZFd2MnlZNFJwMUlpeUlWV0VLRzFQVHoxcFBBRnFFbmFrUHR3NFJNUlRHd0hkYjJpZmNEYlBvRWtmWVFJeEFPTGtmRVBqMjJmQm5lajF3dGd5eWxzdTczcktMVXY0eGhEeTlUQWVWVW1sMGlEQk04U3RFNERpVnMvNGVqRmhxUT09Il19.eyJuZXh0VXBkYXRlIjogIjIwMTctMDktMTkiLCAibm8iOiA0MywgImVudHJpZXMiOiBbeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDEzJTIzMDAwMSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTUtMDUtMjAiLCAiaGFzaCI6ICIwNkxaeEo1bU51TlpqNDhJWkxWODE2YmZwM0E3R1Z0TzJPLUVlUTFwa1RZPSIsICJhYWlkIjogIjAwMTMjMDAwMSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNS0wNS0yMCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxMyUyMzAwNjEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE1LTEyLTIyIiwgImhhc2giOiAiZ1c4OVQxZzkyUmZXVG4yalhhUG8tc05TaW1nNHlwamdob2cwR25NRFA1Yz0iLCAiYWFpZCI6ICIwMDEzIzAwNjEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTUtMTItMjIifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMTMlMjMwMDcxIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNS0xMi0yMiIsICJoYXNoIjogIm5hREJvTndkNEExeGJLZ3FtSVBJbzM0RGNyb05PaWJqMkwtUUF0bE40TU09IiwgImFhaWQiOiAiMDAxMyMwMDcxIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE1LTEyLTIyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDEzJTIzMDA4NCIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTUtMTItMjIiLCAiaGFzaCI6ICJjNy1nT3gxTkFhTF9rcXVXRWl3V3VWWDQtaGhrZDNNZTY0REp3eFhQRXBvPSIsICJhYWlkIjogIjAwMTMjMDA4NCIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNS0xMi0yMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxNCUyM0ZGRjEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTExLTIyIiwgImhhc2giOiAiVlV0SWtQWHloa21GRmMxR2pUcmdGWDBnWnFkX1d4UHZzaTJnY3M5VF8zST0iLCAiYWFpZCI6ICIwMDE0I0ZGRjEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE1LTA5LTI1In0sIHsic3RhdHVzIjogIlJFVk9LRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTExLTIyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDE0JTIzRkZGMiIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMTEtMjIiLCAiaGFzaCI6ICJ1SDJoRTFUOHVJQmhuRjdGcm4zcUs4S0I4SktJLVpKYnBzUlBteWNIZmZzPSIsICJhYWlkIjogIjAwMTQjRkZGMiIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTUtMDktMzAifSwgeyJzdGF0dXMiOiAiUkVWT0tFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMTEtMjIifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMTQlMjNGRkYzIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0xMS0yMiIsICJoYXNoIjogIm1hUXloSW9kSWlqa1lpMkh5c3YtaGhWcC1qUzJILU5rWjBuZlplRElvUHM9IiwgImFhaWQiOiAiMDAxNCNGRkYzIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNS0xMC0zMSJ9LCB7InN0YXR1cyI6ICJSRVZPS0VEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0xMS0yMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxNSUyMzAwMDIiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAxLTA4IiwgImhhc2giOiAiaThfd2N3MWFXRFJpRlVRZWtfbGIwNjhFdUxVY1NoTGpyeGNKVzBCOE92WT0iLCAiYWFpZCI6ICIwMDE1IzAwMDIiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDEtMDgifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMTUlMjMwMDA1IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMi0wOCIsICJoYXNoIjogIlExZHFVck1wU3RwQkEyanJ0clJ6Rkt5amxWc2RpSWdyTU9teDV0dV9iWnc9IiwgImFhaWQiOiAiMDAxNSMwMDA1IiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTAyLTA4In1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDE2JTIzMDAwMSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTUtMDctMjEiLCAiaGFzaCI6ICJ1eWpESnBOSm9LTjlDMmhxOEktd2dVeGtkdXdBV1hRUUM5dXFrVHVHek5rPSIsICJhYWlkIjogIjAwMTYjMDAwMSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNS0wNy0yMSJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxNiUyMzAwMDMiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAyLTEwIiwgImhhc2giOiAidFRlaGVMRDNHS0dqeGZidlYyZG9PX25VbGd5NHF5Y0o0MnhHQlpUTnZ4WT0iLCAiYWFpZCI6ICIwMDE2IzAwMDMiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAyLTEwIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDE2JTIzMDAxMCIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDItMTAiLCAiaGFzaCI6ICJSeWs0enpHSEV0M0hhOG5PQ1J3Wlo0VTh6VFdKeXhxTnFCNHpTcGRHR3k0PSIsICJhYWlkIjogIjAwMTYjMDAxMCIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDItMTAifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMTYlMjMwMDIwIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMi0xMCIsICJoYXNoIjogInBYQVktQ05EV0tiVC1mVS1HclFGQWRyeERDbnM3R1U1Q3JaLVFEbm5TZEE9IiwgImFhaWQiOiAiMDAxNiMwMDIwIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMi0xMCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxNyUyMzA0MDAiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE1LTEyLTI3IiwgImhhc2giOiAiOUg1N2ZHTGEyZjFhQ01wSC1xc1l0V01UX2lVVUh0YzhkOFNZb25BblRvOD0iLCAiYWFpZCI6ICIwMDE3IzA0MDAiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTUtMTItMjcifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMTklMjMwMDA1IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNS0wNy0yMiIsICJoYXNoIjogImxmSmtOYUFHQWViWnpvTnpfMElaUXd4VlVnUHVYU1VJMnBiM0JsTmxZdms9IiwgImFhaWQiOiAiMDAxOSMwMDA1IiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE1LTA3LTIyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDE5JTIzMTAwNSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDItMTAiLCAiaGFzaCI6ICJfWnRiaE5zc2tYdWQ2bXJhMjh5T1R5akxEelFVdkdsOUluLUZaYjJYaTQ0PSIsICJhYWlkIjogIjAwMTkjMTAwNSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMi0xMCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxOSUyMzEwMDkiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE3LTAyLTEwIiwgImhhc2giOiAiS0J0bnZ1M0pjY1l0Q0NJZmR1VzFIV3p1TFZlclo5UlJCWWdyTWFCakIyND0iLCAiYWFpZCI6ICIwMDE5IzEwMDkiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTctMDItMTAifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMUIlMjMwMDAxIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMS0wMSIsICJoYXNoIjogInBRVjJiUjktSU1EYUdGWkpDNkJLYXRmOTN0SVBUZlN2a2xUdkdMam44REE9IiwgImFhaWQiOiAiMDAxQiMwMDAxIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMS0wMSJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxRCUyMzAwMDEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE3LTAzLTMxIiwgImhhc2giOiAiWEhjMzJVWGVmdnNQT1p6LUNOYU5fZFNYUFBYaW5EQ2JRekpqRTZaWWpSdz0iLCAiYWFpZCI6ICIwMDFEIzAwMDEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTAzLTMxIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDFEJTIzMDAwMiIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDUtMDQiLCAiaGFzaCI6ICJhc2NVWGxwdzdDMHJjdFFGaENSNUViS25jLXNWTkxPUFlxd1AxM045Nmk4PSIsICJhYWlkIjogIjAwMUQjMDAwMiIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTctMDUtMDQifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMUQlMjMxMDAxIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMy0yOCIsICJoYXNoIjogImJyWWI2azdacktkYzdBeDFRVEM4ZHd6Q3c5clYxSngxWkl4a3drREJPUTg9IiwgImFhaWQiOiAiMDAxRCMxMDAxIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMy0yOCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxRSUyMzAwMDEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAzLTMxIiwgImhhc2giOiAiNnlycnJnTmRiaXZaN0ktRjRCUnBEeFZZN1hzRHE5WEJWdExydjFQd2dxUT0iLCAiYWFpZCI6ICIwMDFFIzAwMDEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAzLTMxIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDFFJTIzMDAwMiIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDEtMTgiLCAiaGFzaCI6ICI2djdJQzNrMk1uUXNyNFhjWFh3V19zTnBRaS1VWm5LNWxrdWVIdXlKcGRFPSIsICJhYWlkIjogIjAwMUUjMDAwMiIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDEtMTgifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMUUlMjMwMDAzIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMi0wNCIsICJoYXNoIjogIjZIZVNjeEFaWl91MEFnTzdkbWdvMDg4R0ZveWxOQld0VGIzQWNULUMyaGs9IiwgImFhaWQiOiAiMDAxRSMwMDAzIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMi0wNCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxRSUyMzAwMDQiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAyLTA0IiwgImhhc2giOiAiN2ZaRGMwRVJxNEZ1U1d6cEkxTGtwcnk5OFllYnp0NU55VThteUV1TWxoMD0iLCAiYWFpZCI6ICIwMDFFIzAwMDQiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAyLTA0In1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDFFJTIzMDAwNSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDItMDQiLCAiaGFzaCI6ICJ4b1pzQmg1c3Z2aWNqcDdsODVFSEdyckRjUkFIeVhHeWZyVFpXNmlnMVl3PSIsICJhYWlkIjogIjAwMUUjMDAwNSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDItMDQifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMUUlMjMwMDA2IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMi0wNCIsICJoYXNoIjogImtxYV8tOXE4U21EWUpmeTRGb3FTZmpIWURpWmE3RFhOSjRPS3hrUnFxSHM9IiwgImFhaWQiOiAiMDAxRSMwMDA2IiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMi0wNCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAxRSUyMzAwMDciLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAzLTIxIiwgImhhc2giOiAiODR2ZHQwUno0VERfczZhQkpJaFNtQ1ZPSld0U2doSzhmRXpKcnVSMDl0TT0iLCAiYWFpZCI6ICIwMDFFIzAwMDciLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDMtMjEifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMjAlMjNBMTExIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0xMS0yMiIsICJoYXNoIjogInhJRTVUZW9fTlJ3cGsxNUFMSURrVFhUdWN3dG9lMXlSenhYUzVCYkNzWFU9IiwgImFhaWQiOiAiMDAyMCNBMTExIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0xMS0yMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAyMCUyM0EyMDEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAyLTEyIiwgImhhc2giOiAiaFdHNnhHMjB0TjZHTnU2c0NIZjBnNVo2WHRrRTNmRWFrazVwQXlqUDBZTT0iLCAiYWFpZCI6ICIwMDIwI0EyMDEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAyLTEyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDIwJTIzQTIwMiIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDItMTIiLCAiaGFzaCI6ICJ5SzRqVE1BSlFZMmwtV1dJNm1CWmdmQlpaTkpLZzE3VnhTcm9mT0xFWEhRPSIsICJhYWlkIjogIjAwMjAjQTIwMiIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDItMTIifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMjAlMjNBMjAzIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMi0xMiIsICJoYXNoIjogIjBiS19DQ2ZDTWd0aWF5amVtOWU3cWtZQ3FiaGw5c3IwcGgzbWR5SUpfREE9IiwgImFhaWQiOiAiMDAyMCNBMjAzIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMi0xMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAyMCUyM0EyMDQiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE1LTEyLTIyIiwgImhhc2giOiAiZWg3VjRwaU5fVTVCY19mbFBZMzg2RmNoUnc1VzN1QXh1MGo4M3FCMlkxbz0iLCAiYWFpZCI6ICIwMDIwI0EyMDQiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTUtMTItMjIifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMjAlMjNBMjA1IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMi0xMiIsICJoYXNoIjogIlhlRk9pTWs2ajFoaE5hMm14WEdVaDJyenEtUWZ2TnBRNndFcDZWaFNNWmM9IiwgImFhaWQiOiAiMDAyMCNBMjA1IiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMi0xMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAyMCUyM0EyMDYiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAyLTEyIiwgImhhc2giOiAiLTc0bjFKMmFtNWRqWGF0WW9IVGt5dnhhcGlRWEtVMU1DNEhuXzVGMEZRST0iLCAiYWFpZCI6ICIwMDIwI0EyMDYiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAyLTEyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDIwJTIzQjIwNCIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTUtMTItMjIiLCAiaGFzaCI6ICJVQjk2dHdDX0h2cUpQWENOQjFhWHd5bHNnT0ZyV2dUYi15aE9KLW5ZSTJrPSIsICJhYWlkIjogIjAwMjAjQjIwNCIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNS0xMi0yMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDAyOCUyMzAwMDEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAzLTIxIiwgImhhc2giOiAiQ2ZZOHItT1M2NmtYNEJNUkFZbkJVcVFHUzc0bEk2Vy03SDRzQ2FabEU4Zz0iLCAiYWFpZCI6ICIwMDI4IzAwMDEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDMtMjEifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzAwMzElMjMwMDAxIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMy0yMiIsICJoYXNoIjogImRhUnlaMUhKQjFtdlYwaEtESWx0OUxvcWhnU1Rwamo5Y3ZwT2NmVndWNVE9IiwgImFhaWQiOiAiMDAzMSMwMDAxIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTAzLTIyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS8wMDMxJTIzMDAwMiIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDMtMjIiLCAiaGFzaCI6ICJVUEFoVHk1RnhFTEZNdUdOTm0zOFYxdEVEVzVacVc4MmpWMWRjLS02VDFrPSIsICJhYWlkIjogIjAwMzEjMDAwMiIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMy0yMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvMDk2RSUyMzAwMDQiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE3LTAxLTA0IiwgImhhc2giOiAiQWdOMlVsSUtBNFcwMW5nV0RkeVlZc1hWNDNfVzBxaEJUZDFhQ1pMZ09JRT0iLCAiYWFpZCI6ICIwOTZFIzAwMDQiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTctMDEtMDQifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzFFQTglMjM4MDgxIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wNC0wNyIsICJoYXNoIjogImpUVkFWU1dHZk42M3lLNkdCQWQ1eGdOTURhYXZ4NHl0Zmw3QS1SODVBVGs9IiwgImFhaWQiOiAiMUVBOCM4MDgxIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTA0LTA3In1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS80NzQ2JTIzMzIwOCIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDYtMDciLCAiaGFzaCI6ICJEdXVHNGh4QmhlLUpveE9uOFN6T2NmVzBtNU82TVhOQjN0VmhzT3F1MWM4PSIsICJhYWlkIjogIjQ3NDYjMzIwOCIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wNi0wNyJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvNDc0NiUyMzUyMDYiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE3LTAzLTA5IiwgImhhc2giOiAib2xDNnpOMTJQMWlfN1VxRnBMbmZIWEF6VW1ta2ExWXlVa19WX0V3WnI4Yz0iLCAiYWFpZCI6ICI0NzQ2IzUyMDYiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTctMDMtMDkifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzQ3NDYlMjNGODE2IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNS0xMC0xMiIsICJoYXNoIjogIlB3aGNSQXh3alF4bHdxb1dvTGhrRWEtNXV2T200SURQTXdGR0w1a0xEQ3M9IiwgImFhaWQiOiAiNDc0NiNGODE2IiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE1LTEwLTEyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS80ZTRlJTIzNDAwNSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTUtMDktMTUiLCAiaGFzaCI6ICJqSUZSc3BQZEZiQjZtb0ZCeUdielN1a19IMk1QaXFhT3pkVDFnemZuQk9jPSIsICJhYWlkIjogIjRlNGUjNDAwNSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTUtMDktMTUifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzRlNGUlMjM0MDA2IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMy0xNCIsICJoYXNoIjogIk8yajRDN0ZscnR3LWRkVkdsMVZjQ2pmdlhhcUNjdzluUHdCMEgwWHpQSjg9IiwgImFhaWQiOiAiNGU0ZSM0MDA2IiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMy0xNCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvNGU0ZSUyMzQwMDkiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAzLTE0IiwgImhhc2giOiAiZXlMTUY0NDVjUExfVEtzY2ZZR2VZcmItYllYMDJEbkFkaWx3MEtMR01Mbz0iLCAiYWFpZCI6ICI0ZTRlIzQwMDkiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAzLTE0In1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS80ZTRlJTIzNDAwYSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDMtMTQiLCAiaGFzaCI6ICJWWXFpZEc4WThkOUQ2RjdBcmVRaWlyT1VVd0taajE1N0VqRGRVaWdGQ29zPSIsICJhYWlkIjogIjRlNGUjNDAwYSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDMtMTQifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhLzRlNGUlMjM0MDBiIiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNi0wMy0xNCIsICJoYXNoIjogIkRTZV9HZThCSi1leFZXRFF4NFBTX2VkZEVlYnlObjBRS2ZGUjFlVFNCU3c9IiwgImFhaWQiOiAiNGU0ZSM0MDBiIiwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiTk9UX0ZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNi0wMy0xNCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvNGU0ZSUyMzQwMTAiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE2LTAzLTE0IiwgImhhc2giOiAiMGhJSWJSNGplZ1BkWENWM0ZmLWJsYzB1LVJtWVp6QVJ1ajRBVWJLVEdxdz0iLCAiYWFpZCI6ICI0ZTRlIzQwMTAiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJOT1RfRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE2LTAzLTE0In1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS80ZTRlJTIzNDAxMSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTYtMDMtMTQiLCAiaGFzaCI6ICJtVUs4clVEa0dBU2pwNUM2MVBRQ0VtU3hSb05JNWlZMmNaQ25EMHp5OWdnPSIsICJhYWlkIjogIjRlNGUjNDAxMSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIk5PVF9GSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTYtMDMtMTQifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhL2JiRVBtZDM2aHJvc2lWYnhCWmNHN2YiLCAiaGFzaCI6ICJHV0FLbEtmVmwxMC1oMmlQQl9uY2hiZWZhcnJiZDFmVG9YSXYxWThjS1dZPSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDItMTEiLCAiYXR0ZXN0YXRpb25DZXJ0aWZpY2F0ZUtleUlkZW50aWZpZXJzIjogWyI5NDFiNjczODRmZjAzMzMwYjcwZGNjYTU4ZjcyMTYzMmYwNDcyNmQyIl0sICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMi0xMSJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvQnoyRExHdHhQYzRkU0RGa2VaNkJUQyIsICJoYXNoIjogIllpNzI3SUUtRVJkbEJIT2VyUE54cmExaTZrTnJqalBaX2h3NURkX3FRQm89IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMS0yNCIsICJhdHRlc3RhdGlvbkNlcnRpZmljYXRlS2V5SWRlbnRpZmllcnMiOiBbIjQxODM3N2UyMTNkYjE0YWJjNjUwOWRiNWUxMGM5NTk4YjQyZjkyZWEiXSwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTAxLTI0In1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS9EQUI4JTIzMDAxMSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTUtMTAtMDIiLCAiaGFzaCI6ICJ5NGlPSlp1S0x2MUVYa3VXQVFrWFF1QXgzbmI4THZCdFd4OUpMcWlWQjY4PSIsICJhYWlkIjogIkRBQjgjMDAxMSIsICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNS0xMC0wMiJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvREFCOCUyMzEwMTEiLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE1LTEyLTIzIiwgImhhc2giOiAiYW51TVFoWnpLUnpGSEoyd1ppWVV2RzFyUXFtODd1YU5DeFJNUHh3RFZ5ST0iLCAiYWFpZCI6ICJEQUI4IzEwMTEiLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTUtMTItMjMifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhL2VoNE56TTRjMjRBejVXVEpnaVBScEwiLCAiaGFzaCI6ICJhSEtUS1I2UTU3SEptd1d4RklETlRKM3VNaVZjWnNQZ1pxVDAzeHJfbG9BPSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDgtMjUiLCAiYXR0ZXN0YXRpb25DZXJ0aWZpY2F0ZUtleUlkZW50aWZpZXJzIjogWyI2Y2Q5OWQ4YjBhYmZhNmE0Mzc4MTM4YTE0NzVmN2U0NmRmMjE3YTI1IiwgIjdhOGZlMzdhNDJiYmYyYTViM2U2NTc0ZDZmMDRiZGJjNTVlNTkwNDciLCAiNTU0NjRkNWJlYTg0ZTcwNzMwNzRiMjFkMTIwNDkzNDM1OGM3ZGI0ZCIsICJjMTBiYzRjNmY2MTRiNjMzNzFkOTI5NTk2ZWRlZGRlM2U0NTg0MDRkIl0sICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMy0xNCJ9LCB7InN0YXR1cyI6ICJSRVZPS0VEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wOC0yNSJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvZVM3djhzdW00anhwN2tnTFE1UXFjZyIsICJoYXNoIjogIlJEend0WUNsV1V5YXJVLTdZc0tjODdTYkpSS3J0bjhDekh1aWEyM1BGbnc9IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMy0xNCIsICJhdHRlc3RhdGlvbkNlcnRpZmljYXRlS2V5SWRlbnRpZmllcnMiOiBbImQ1ZGI0ZGQ0OGZlNDZhZmQ4YWY4ZjFmN2NmYmRlZTYxNjQwYmJiY2MiLCAiNTU0NjRkNWJlYTg0ZTcwNzMwNzRiMjFkMTIwNDkzNDM1OGM3ZGI0ZCJdLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTctMDMtMTQifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhL0ZiRloyS0Z2aTlCQ3JVZFNzWkpEUmUiLCAiaGFzaCI6ICJVbEt0UUl5aGl1dzRUejJIc19VNzBEaWJvRnNWLUFiVktOeEtUTlVNanNJPSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDItMDgiLCAiYXR0ZXN0YXRpb25DZXJ0aWZpY2F0ZUtleUlkZW50aWZpZXJzIjogWyJkM2ExNTk4YzA5ZGNkNTExNDI5NzNmMWJiN2M4YmQ2NTJlOTNiMTA1Il0sICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMi0wOCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEvSktQNUNpRGVoZE1NUHd0RzVpN3RvNSIsICJoYXNoIjogIkJNYjZVOUtJbEFMZW5RQm8yS0ZfM0lnTTVkZGlPS2ZJTzBJVzVTX3I4M3c9IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMy0wMiIsICJhdHRlc3RhdGlvbkNlcnRpZmljYXRlS2V5SWRlbnRpZmllcnMiOiBbImE1YTM1MzBlMDNhMGYyMTE4Mzk5YWMwYjZjM2M5ZDU1MmEwZDM0ZjgiXSwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTAzLTAyIn1dfSwgeyJ1cmwiOiAiaHR0cHM6Ly9tZHMuZmlkb2FsbGlhbmNlLm9yZy9tZXRhZGF0YS9OOVVvN1c0Y05udmE3Mkxxd0dKUm5kIiwgImhhc2giOiAiZVZkS0VsWDJqZXg0X1JoRWVxMXVpYjE4RnBPcGYwUUNQNDhyUVgxYkVOYz0iLCAidGltZU9mTGFzdFN0YXR1c0NoYW5nZSI6ICIyMDE3LTAyLTIwIiwgImF0dGVzdGF0aW9uQ2VydGlmaWNhdGVLZXlJZGVudGlmaWVycyI6IFsiNmJhYjE5YzZjMDk3ZjE5MDYwY2U1NDA0MDAwMzgwYzMyZmE2YThlNiJdLCAic3RhdHVzUmVwb3J0cyI6IFt7InN0YXR1cyI6ICJGSURPX0NFUlRJRklFRCIsICJ1cmwiOiAiIiwgImNlcnRpZmljYXRlIjogIiIsICJlZmZlY3RpdmVEYXRlIjogIjIwMTctMDItMjAifV19LCB7InVybCI6ICJodHRwczovL21kcy5maWRvYWxsaWFuY2Uub3JnL21ldGFkYXRhL1Y0ZnpBZFZGRGpROHhneTR2azJEc1EiLCAiaGFzaCI6ICJEMExrdzhINl9BNlBVNkhpUjdjblZ2bEk3TnZBb1NJRDlaRnRZTzBicG1zPSIsICJ0aW1lT2ZMYXN0U3RhdHVzQ2hhbmdlIjogIjIwMTctMDItMDgiLCAiYXR0ZXN0YXRpb25DZXJ0aWZpY2F0ZUtleUlkZW50aWZpZXJzIjogWyJjODg4NzFhNDM4ZWY5N2M0ZDgzMjA3ZDZmMTYxMTM5MjdhZjhlZjNhIl0sICJzdGF0dXNSZXBvcnRzIjogW3sic3RhdHVzIjogIkZJRE9fQ0VSVElGSUVEIiwgInVybCI6ICIiLCAiY2VydGlmaWNhdGUiOiAiIiwgImVmZmVjdGl2ZURhdGUiOiAiMjAxNy0wMi0wOCJ9XX0sIHsidXJsIjogImh0dHBzOi8vbWRzLmZpZG9hbGxpYW5jZS5vcmcvbWV0YWRhdGEveU1VRkNQMnF6anNZc2JIZ0VZWlNWOSIsICJoYXNoIjogIjZKbllrejRURDh1d3NIZVFTcDgtX1lGbWhkQS1wMGthTkhfN21xQl8wY3M9IiwgInRpbWVPZkxhc3RTdGF0dXNDaGFuZ2UiOiAiMjAxNy0wMy0yMyIsICJhdHRlc3RhdGlvbkNlcnRpZmljYXRlS2V5SWRlbnRpZmllcnMiOiBbImZiZWMxMmM0Mjg3NzRkMzFiZTRkNzcyMzY3NThlYTNjMDQxYTJlZDAiXSwgInN0YXR1c1JlcG9ydHMiOiBbeyJzdGF0dXMiOiAiRklET19DRVJUSUZJRUQiLCAidXJsIjogIiIsICJjZXJ0aWZpY2F0ZSI6ICIiLCAiZWZmZWN0aXZlRGF0ZSI6ICIyMDE3LTAzLTIzIn1dfV19.DL0cHehH2oPG7LWPkSZN3y4FnOzJ5_RqClwSMSiPHscZysp1KgTrlPRkudltcAIwcq7wWARLiemCguHcNVZuNA";
        SignedJWT jwt = (SignedJWT) JWTParser.parse(token);
        target.verify(jwt);
    }
}

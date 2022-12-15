package com.POJO;

import java.util.Map;

public class Currency {
    private Status status;
    private Data data;

    public static class Status {
        private String timestamp;
        private int error_code;
        private Object error_message;
        private int elapsed;
        private int credit_count;
        private Object notice;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public Object getError_message() {
            return error_message;
        }

        public void setError_message(Object error_message) {
            this.error_message = error_message;
        }

        public int getElapsed() {
            return elapsed;
        }

        public void setElapsed(int elapsed) {
            this.elapsed = elapsed;
        }

        public int getCredit_count() {
            return credit_count;
        }

        public void setCredit_count(int credit_count) {
            this.credit_count = credit_count;
        }

        public Object getNotice() {
            return notice;
        }

        public void setNotice(Object notice) {
            this.notice = notice;
        }
// getters and setters
    }

    public static class Data {
        private int id;
        private String symbol;
        private String name;
        private int amount;
        private String last_updated;
        private Map<String, Quote> quote;


        public static class Quote {
            private double price;
            private String last_updated;

            public double getPrice() {
                return price;
            }

            public String getLast_updated() {
                return last_updated;
            }
// getters and setters

            public void setPrice(double price) {
                this.price = price;
            }

            public void setLast_updated(String last_updated) {
                this.last_updated = last_updated;
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public Map<String, Quote> getQuote() {
            return quote;
        }

        public void setQuote(Map<String, Quote> quote) {
            this.quote = quote;
        }
// getters and setters
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // getters and setters
}

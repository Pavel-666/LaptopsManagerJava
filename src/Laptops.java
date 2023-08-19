
public class Laptops {

        private static int count = 0;
        private int order;
        private String model;
        private int ram;
        private int hard;
        private String os;
        private String color;

        private void setValues(String model, int ram, String os, String color, int hard) {
            this.order = ++count;
            this.model = model;
            this.ram = ram;
            this.os = os;
            this.hard = hard;
            this.color = color;
        }

        public Laptops(String model, int ram, String os, String color, int hard) {
            setValues(model, ram, os, color, hard);
        }

        public int getOrder() {
            return this.order;
        }

        public int getRam() {
            return this.ram;
        }

        public int getHard() {
            return this.hard;
        }

        public String getModel() {
            return this.model;
        }

        public String getOs() {
            return this.os;
        }

        public String getColor() {
            return this.color;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.order);
            stringBuilder.append(" Laptop: ");
            stringBuilder.append(this.model);
            stringBuilder.append(", ");
            stringBuilder.append("операционная система ");
            stringBuilder.append(this.os);
            stringBuilder.append(", ");
            stringBuilder.append("оперативная память ");
            stringBuilder.append(this.ram);
            stringBuilder.append("gb");
            stringBuilder.append(", ");
            stringBuilder.append("жесткий диск ");
            stringBuilder.append(this.hard);
            stringBuilder.append("gb");
            stringBuilder.append(", ");
            stringBuilder.append("цвет ");
            stringBuilder.append(this.color);
            stringBuilder.append(";");
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }

}

/* Generated SBE (Simple Binary Encoding) message codec. */
package messages.marketdata;

import org.agrona.DirectBuffer;


/**
 * Ask Side Book Update
 */
@SuppressWarnings("all")
public final class AskBookUpdateDecoder
{
    public static final int BLOCK_LENGTH = 12;
    public static final int TEMPLATE_ID = 15;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final AskBookUpdateDecoder parentMessage = this;
    private DirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;
    int actingBlockLength;
    int actingVersion;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int initialOffset()
    {
        return initialOffset;
    }

    public int offset()
    {
        return offset;
    }

    public AskBookUpdateDecoder wrap(
        final DirectBuffer buffer,
        final int offset,
        final int actingBlockLength,
        final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
    }

    public AskBookUpdateDecoder wrapAndApplyHeader(
        final DirectBuffer buffer,
        final int offset,
        final MessageHeaderDecoder headerDecoder)
    {
        headerDecoder.wrap(buffer, offset);

        final int templateId = headerDecoder.templateId();
        if (TEMPLATE_ID != templateId)
        {
            throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
        }

        return wrap(
            buffer,
            offset + MessageHeaderDecoder.ENCODED_LENGTH,
            headerDecoder.blockLength(),
            headerDecoder.version());
    }

    public AskBookUpdateDecoder sbeRewind()
    {
        return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
    }

    public int sbeDecodedLength()
    {
        final int currentLimit = limit();
        sbeSkip();
        final int decodedLength = encodedLength();
        limit(currentLimit);

        return decodedLength;
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int instrumentIdId()
    {
        return 16;
    }

    public static int instrumentIdSinceVersion()
    {
        return 0;
    }

    public static int instrumentIdEncodingOffset()
    {
        return 0;
    }

    public static int instrumentIdEncodingLength()
    {
        return 8;
    }

    public static String instrumentIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public static long instrumentIdNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long instrumentIdMinValue()
    {
        return 0x0L;
    }

    public static long instrumentIdMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public long instrumentId()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int venueId()
    {
        return 17;
    }

    public static int venueSinceVersion()
    {
        return 0;
    }

    public static int venueEncodingOffset()
    {
        return 8;
    }

    public static int venueEncodingLength()
    {
        return 4;
    }

    public static String venueMetaAttribute(final MetaAttribute metaAttribute)
    {
        if (MetaAttribute.PRESENCE == metaAttribute)
        {
            return "required";
        }

        return "";
    }

    public int venueRaw()
    {
        return buffer.getInt(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public Venue venue()
    {
        return Venue.get(buffer.getInt(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN));
    }


    private final AskBookDecoder askBook = new AskBookDecoder(this);

    public static long askBookDecoderId()
    {
        return 18;
    }

    public static int askBookDecoderSinceVersion()
    {
        return 0;
    }

    public AskBookDecoder askBook()
    {
        askBook.wrap(buffer);
        return askBook;
    }

    public static final class AskBookDecoder
        implements Iterable<AskBookDecoder>, java.util.Iterator<AskBookDecoder>
    {
        public static final int HEADER_SIZE = 4;
        private final AskBookUpdateDecoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        AskBookDecoder(final AskBookUpdateDecoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = 0;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = (buffer.getShort(limit + 2, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        }

        public AskBookDecoder next()
        {
            if (index >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
        }

        public static int countMinValue()
        {
            return 0;
        }

        public static int countMaxValue()
        {
            return 65534;
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 16;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<AskBookDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return index < count;
        }

        public static int priceId()
        {
            return 19;
        }

        public static int priceSinceVersion()
        {
            return 0;
        }

        public static int priceEncodingOffset()
        {
            return 0;
        }

        public static int priceEncodingLength()
        {
            return 8;
        }

        public static String priceMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long priceNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long priceMinValue()
        {
            return 0x0L;
        }

        public static long priceMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long price()
        {
            return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int sizeId()
        {
            return 20;
        }

        public static int sizeSinceVersion()
        {
            return 0;
        }

        public static int sizeEncodingOffset()
        {
            return 8;
        }

        public static int sizeEncodingLength()
        {
            return 8;
        }

        public static String sizeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long sizeNullValue()
        {
            return 0xffffffffffffffffL;
        }

        public static long sizeMinValue()
        {
            return 0x0L;
        }

        public static long sizeMaxValue()
        {
            return 0xfffffffffffffffeL;
        }

        public long size()
        {
            return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("price=");
            builder.append(price());
            builder.append('|');
            builder.append("size=");
            builder.append(size());
            builder.append(')');

            return builder;
        }
        
        public AskBookDecoder sbeSkip()
        {

            return this;
        }
    }

    public String toString()
    {
        if (null == buffer)
        {
            return "";
        }

        final AskBookUpdateDecoder decoder = new AskBookUpdateDecoder();
        decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

        return decoder.appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final int originalLimit = limit();
        limit(initialOffset + actingBlockLength);
        builder.append("[AskBookUpdate](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        builder.append("instrumentId=");
        builder.append(instrumentId());
        builder.append('|');
        builder.append("venue=");
        builder.append(venue());
        builder.append('|');
        builder.append("askBook=[");
        final int askBookOriginalOffset = askBook.offset;
        final int askBookOriginalIndex = askBook.index;
        final AskBookDecoder askBook = askBook();
        if (askBook.count() > 0)
        {
            while (askBook.hasNext())
            {
                askBook.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        askBook.offset = askBookOriginalOffset;
        askBook.index = askBookOriginalIndex;
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
    
    public AskBookUpdateDecoder sbeSkip()
    {
        sbeRewind();
        AskBookDecoder askBook = askBook();
        if (askBook.count() > 0)
        {
            while (askBook.hasNext())
            {
                askBook.next();
                askBook.sbeSkip();
            }
        }

        return this;
    }
}

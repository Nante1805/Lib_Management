DO $$ BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'topic') THEN
        CREATE TYPE topic AS ENUM ('ROMANCE', 'COMEDY', 'OTHER');
    END IF;
END $$;
